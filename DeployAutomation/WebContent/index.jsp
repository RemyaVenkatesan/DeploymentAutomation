<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Deployment Automation</title>
<link rel="stylesheet" href="css/bootstrap.min.css">

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>  
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
			
<!-- <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.2/jquery.min.js"></script>
<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script> -->

<script type="text/javascript" 
	src="<%=request.getContextPath()%>/resources/js/jquery-1.10.2.min.js"></script>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/resources/js/bootstrap.min.js"></script>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/resources/js/jquery.min.js"></script>
</head>

<link href="${pageContext.servletContext.contextPath}/resources/css/bootstrap.min.css" rel="stylesheet" />

<!-- style="background:#E6E6FA" -->
<body >
   <script type="text/javascript">
   
   function insertHeader()
   {
	   document.location.href='DeploymentAutomation'; 
   }
   
 
   
   function unCheckOthers(obj){
	 // $(".itemChk").attr("checked", false); //uncheck all checkboxes
	   $('.itemChk').not(obj).prop('checked', false);  
	  // alert($(obj).val());
	  // $(obj).attr("checked", true);  //check the clicked one
   }
    
   function insertItems()
   {
	   document.location.href='DeploymentItems'; 
   }
   
   function updateItems(){
	   var itemId = null;
	   $(".itemChk").each(function(e){
	   if( $(this).is(":checked")){
		   itemId = $(this).val();
		 // alert( $(this).val());
	   }
	   });
	  
	   $("#deployment").val($("#"+itemId).find(".deploymentOrder").text());
	 
	   $("#projectName").val($("#"+itemId).find(".projectId").val());
	   $("#comments").val($("#"+itemId).find(".comments").text());
	   $("#notes").val($("#"+itemId).find(".notes").text());
	   $("#item").val(itemId);
   }
   
  
   function deleteItem(){
	   var itemId = null;
	   $(".itemChk").each(function(e){
	   if( $(this).is(":checked")){
		   itemId = $(this).val();
		   alert( $(this).val());
	   }
	   });

	   
	  alert(itemId);
	  document.location.href='DeleteItems?itemId='+itemId+'&deploymentId='+${deploymentHeader.deployment_Id};
	 
   }
   
   function ArchiveHeader()
   {
	   //alert(${releaseHeader.release_Id});
	   
	   document.location.href='ArchiveMaifest?deploymentId='+${deploymentHeader.deployment_Id};
   }
   
   function NewManifest()
   {
	   document.location.href='DeploymentManifest';
   }
   
   </script>

<div class="container">
<h2>
<center>Deployment Manifest</center>
</h2>


<div class="row">
<div class="col-sm-4">
<form class="form-inline" method="post" role="form" action="DeploymentAutomation">
    <div class="form-group">
     
      <input type="hidden" class="form-control" id="Id" name="id" value="${deploymentHeader.deployment_Id }">
     
    </div>

<div class="form-group">
      <label for="Name">Name:</label>
      <input type="text" class="form-control" id="Name" name="name" placeholder="Enter Name" value="${deploymentHeader.deployment_Name }" >
    </div>

<div class="form-group">
      <label for="Archive Manifest">Tag:</label>
      <input type="text" class="form-control" id="Archive Manifest" name="tag" placeholder="Enter code Location" value="${deploymentHeader.tag }">
    </div>


<br>
<br>
<button type="submit" class="btn btn-primary" id="getHeader" onclick="insertHeader()">Save</button>



<button type="button" class="btn btn-primary ">Edit</button>


<br><br>


<button type="button" class="btn btn-primary">Build&Release</button>


<br>


</div>




<div class="col-sm-4">




<br></br>
<div class="form-group">
<button type="button" class="btn btn-primary" onclick="ArchiveHeader()">Archive Manifest</button>
</div>

</form>

</div>



<div class="col-sm-4">


<form class="form-inline" role="form">
<button type="button" class="btn btn-primary" onclick="NewManifest()">New Deployment Manifest</button>

<ul class="list-group">

 		<c:forEach items="${headerArray}" var="current">
 		
                  <li class="list-group-item"><a href="ViewManifest?id=${current.deployment_Id}">/${current.deploy_Date}/${current.tag}/${current.deployment_Name}</a></li>
           </c:forEach>
           </ul>

</form>

</div>

 
<br>
<br>




		<div class="row">
	    <div class="col-md-8">
		
		<table class="table table-hover table-nonfluid" >
		<thead>
				<tr>
					<th></th>
					 <th>S.No</th>
   					 <th>Deployment Order</th>
    				<th>Project</th>
   					 <th>Comments</th>
   					<th>Notes</th>
				</tr>
			</thead>

			<tbody>
			

		    <c:forEach items="${itemsArray}" var="items">
			<tr id="${items.item_Id }" >

			<input type="hidden" class="projectId" value="${items.project.project_id }">
			<td>

				<div>
      			<label><input class="itemChk" name="itemChk" type="checkbox" onchange="unCheckOthers(this);" id="itemId" value="${items.item_Id }"></label>
    			</div>
			</td>
			<c:set var="count" value="${count + 1}" scope="page"/>
    		<td>${count}</td>
		    <td class="deploymentOrder">${items.deployment_Order}</td>
   			<td class="projectName">${items.project.project_Name}  </td>
			<td class="comments" >${items.comments}</td>
			<td class="notes">${items.notes}</td>

		   </tr>
		   
		 </c:forEach>
	</tbody>
</table>
</div>
</div>

<br>

<form class="form-inline" method="post" role="form" action="DeploymentItems">

<button type="button" class="btn btn-info btn-lg" data-toggle="modal" data-target="#myModal">Add</button>


      <input type="hidden" class="form-control" id="id" name="id" value="${deploymentHeader.deployment_Id }">
              
               
               
<div id="myModal" class="modal fade" role="dialog">
  <div class="modal-dialog">
 
 <input type="hidden" class="form-control" id="item" name="itemId" >
    <!-- Modal content-->
    <div class="modal-content">
           <div class="modal-header">
            <button type="button" class="close" data-dismiss="modal">&times;</button>
            <h4 class="modal-title"></h4>
            </div>
      
         <div class="modal-body">
        
             <form class="form-horizontal" role="form">
            <div class="form-group">
              <label class="control-label col-sm-2" for="Defect/Story">DeploymentOrder&emsp;</label>
          
              <div class="col-sm-20">
           <input type="text" class="form-control" id="deployment" name="deployment" placeholder="Enter DeploymentOrder">
             </div>
            </div>


       <div class="form-group">
         <label for="Project" class="control-label col-sm-2">Project&emsp;</label>
         <div id="container">
         
        <select class="form-control" id="projectName" name="project" style="width: 460px;">
         <c:forEach items="${ProjectName}" var="names">
         <option value="${names.project_id}">${names.project_Name }</option>
         </c:forEach>
        </select>
        
        </div>
      </div>




       <div class="form-group">
       <label class="control-label col-sm-2" for="pwd">Comments&emsp;</label>
          <div class="col-sm-20">
          
          <input type="text" class="form-control" id="comments" name="comments" placeholder="Enter Comments">
      </div>
      </div>


      <div class="form-group">
       <label class="control-label col-sm-2" for="pwd">Notes&emsp;</label>
       <div class="col-sm-20">
        <input type="text" class="form-control" id="notes" name="notes" placeholder="Enter Notes">
       </div>
     </div>
 

     <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
        <button type="submit" class="btn btn-primary"  >Save changes</button>
     </div>
    
</div>

  </div>
</div>
</div>


<button type="button" onclick="updateItems();" class="btn btn-info btn-lg" data-toggle="modal" data-target="#myModal" >Update</button>

<button type="button" class="btn btn-info btn-lg" onclick="deleteItem()" >Delete</button>

</form>



</div>


</body>
</html>