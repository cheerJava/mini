<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML>
<html>
  <head>
	<jsp:include page="../common/meta.jsp" />
    <title>产品录入</title>
	<jsp:include page="../common/resources.jsp" />
	<script src="${path}/scripts/plugins/alert/js/dialog.js?20151239"></script>
	<link href="${path}/scripts/plugins/alert/css/dialog.css?20151239" rel="stylesheet">
	<script src="${path}/scripts/demo/form.js" ></script>
	
	

  </head>
  
   <body>
	
    <jsp:include page="../common/header.jsp" />
      <div class="container-fluid">

      <div class="row row-offcanvas row-offcanvas-right">
 		<jsp:include page="../common/menu.jsp" />
        <div class="col-xs-12 col-sm-9">
          <p class="pull-right visible-xs">
            <button type="button" class="btn btn-primary btn-xs" data-toggle="offcanvas">导航栏</button>
          </p>
          
          <div class="panel panel-default">
            <div class="panel-heading">
               <h3 class="panel-title">新增产品</h3>
            </div>
            <div class="panel-body">
            
            <div class="row">
             <form class="form" id="prdForm" role="form"  method="post">
             <div class="row">
	             <div class="col-md-12">
		             <div class="col-md-6">
		              	<div class="form-group">
						    <div class="input-group">
						      <div class="input-group-addon">产品名称</div>
						      <input class="form-control" type="text" id ="prdName" name="prdName" placeholder="请输入产品简称">
						    </div>
						  </div>			 
					</div>
					  <div class="col-md-6">
						  <div class="form-group">
						    <div class="input-group">
						      <div class="input-group-addon">发行商</div>
						      <input class="form-control"  type="text" placeholder="请输入发行商">
						       
						    </div>
						  </div>
					</div>
				</div>
			</div>
			
			 <div class="row">
	             <div class="col-md-12">
					 <div class="col-md-6">
						  <div class="form-group">
						    <div class="input-group">
						      <div class="input-group-addon">产品规模</div>
						      <input class="form-control" id ="prdSize" name="prdSize" type="text" placeholder="请输入产品规模">
						       <div class="input-group-addon">亿</div>
						    </div>
						  </div>
					</div>
					 <div class="col-md-6">
						  <div class="form-group">
						    <div class="input-group">
						      <div class="input-group-addon">产品期限</div>
						      <input class="form-control" id ="prdPeriod" name="prdPeriod" type="text" placeholder="请输入期限">
						       <div class="input-group-addon">月</div>
						    </div>
						  </div>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col-md-12">
					<div class="col-md-6">
					  <div class="form-group">
					    <div class="input-group">
					      <div class="input-group-addon">认购起点</div>
					      <input class="form-control" type="text" placeholder="请输入认购起点">
					       <div class="input-group-addon">万</div>
					    </div>
					  </div>
					</div>
					<div class="col-md-6">
					  <div class="form-group">
					    <div class="input-group">
					      <div class="input-group-addon">佣金基数</div>
					      <input class="form-control" type="text" placeholder="请输入佣金基数">
					    </div>
					  </div>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col-md-12">
					<div class="col-md-6">
						 <div class="form-group">
						    <div class="input-group">
						      <div class="input-group-addon">产品分类</div>
							     <select class="form-control">
								  <option>基金</option>
								  <option>银行理财</option>
								  <option>信托</option>
								  <option>资管</option>
								  <option>P2P</option>
								  <option>债券</option>
								</select>
						    </div>
						  </div>
					</div>
					<div class="col-md-6">
						  <div class="form-group">
						    <div class="input-group">
						      <div class="input-group-addon">客服电话</div>
						      <input class="form-control" type="text" placeholder="请输入交客服电话">
						    </div>
						  </div>
					</div>
				</div>
			</div>
			
			<div class="row">
				<div class="col-md-12">
					<div class="col-md-6">
						  <div class="form-group">
						    <div class="input-group">
						      <div class="input-group-addon">发行日期</div>
						      <input type="text" name="reservation" id="reservation" class="form-control" readonly value="" /> 
						    </div>
						  </div>
					</div>
					<div class="col-md-6">
						  <div class="form-group">
						    <div class="input-group">
						      <div class="input-group-addon">发行日期</div>
						     <input type="text" class="form-control" readonly value="" id="datetimepicker">
						    </div>
						  </div>
					</div>
				</div>
			</div>
			
			<div class="row">
				<div class = "col-md-12">
					<div class="col-md-6">
						  <div class="form-group">
						    <div class="input-group">
						      <div class="input-group-addon">产品亮点</div>
						      <textarea class="form-control" rows="3"></textarea>
						    </div>
						  </div>
					</div>
					<div class="col-md-6">
						  <div class="form-group">
						    <div class="input-group">
						      <div class="input-group-addon">风险措施</div>
						      <textarea class="form-control" rows="3"></textarea>
						    </div>
						  </div>
					</div>
				 </div>
			 </div>
 
			 <div class="row">
				<div class = "col-md-12">
		 			 <div class="col-md-6">
		              	<div class="form-group">
						    <div class="input-group">
						      <div class="input-group-addon">产品简称</div>
						      <input class="form-control" type="text" placeholder="请输入产品简称">
						    </div>
						  </div>
					</div>
					 <div class="col-md-6">
						  <div class="form-group">
						    <div class="input-group">
						      <div class="input-group-addon">发行商</div>
						      <input class="form-control" type="text" placeholder="请输入发行商">
						    </div>
						  </div>
					</div>
				</div>
			</div>	
			 <div class="row">
				<div class = "col-md-12">
					 <div class="col-md-6">
						  <div class="form-group">
						    <div class="input-group">
						      <div class="input-group-addon">产品规模</div>
						      <input class="form-control" type="text" placeholder="请输入产品规模">
						       <div class="input-group-addon">亿</div>
						    </div>
						  </div>
					</div>
					 <div class="col-md-6">
						  <div class="form-group">
						    <div class="input-group">
						      <div class="input-group-addon">产品期限</div>
						      <input class="form-control" type="text" placeholder="请输入期限">
						       <div class="input-group-addon">月</div>
						    </div>
						  </div>
					</div>
				</div>
			</div>
			
			 <div class="row">
				<div class = "col-md-12">
					<div class="col-md-6">
						  <div class="form-group">
						    <div class="input-group">
						      <div class="input-group-addon">认购起点</div>
						      <input class="form-control" type="text" placeholder="请输入认购起点">
						       <div class="input-group-addon">万</div>
						    </div>
						  </div>
					</div>
					<div class="col-md-6">
						  <div class="form-group">
						    <div class="input-group">
						      <div class="input-group-addon">佣金基数</div>
						      <input class="form-control" type="text" placeholder="请输入佣金基数">
						    </div>
						  </div>
					</div>
				</div>
			</div>
			
			<div class="row">
				<div class = "col-md-12">
					<div class="col-md-6">
						  <div class="form-group">
						    <div class="input-group">
						      <div class="input-group-addon">交易对手</div>
						      <input class="form-control" type="text" placeholder="请输入交易对手">
						    </div>
						  </div>
					</div>
					<div class="col-md-6">
						  <div class="form-group">
						    <div class="input-group">
						      <div class="input-group-addon">客服电话</div>
						      <input class="form-control" type="text" placeholder="请输入交客服电话">
						    </div>
						  </div>
					</div>
				</div>
			</div>
			
			<div class="row">
				<div class = "col-md-12">
					<div class="col-md-6">
						  <div class="form-group">
						    <div class="input-group">
						      <div class="input-group-addon">发行日期</div>
						      <input type="text" name="reservation" id="reservation" class="form-control" readonly value="" /> 
						    </div>
						  </div>
					</div>	
					<div class="col-md-6">
						  <div class="form-group">
						    <div class="input-group">
						      <div class="input-group-addon">发行日期</div>
						     <input type="text" class="form-control" readonly value="" id="datetimepicker">
						    </div>
						  </div>
					</div>
				</div>
			</div>
			
			<div class="row">
				<div class = "col-md-12">
					<div class="col-md-6">
						  <div class="form-group">
						    <div class="input-group">
						      <div class="input-group-addon">产品亮点</div>
						      <textarea class="form-control" rows="3"></textarea>
						    </div>
						  </div>
					</div>
					<div class="col-md-6">
						  <div class="form-group">
						    <div class="input-group">
						      <div class="input-group-addon">风险措施</div>
						      <textarea class="form-control" rows="3"></textarea>
						    </div>
						  </div>
					</div>
				</div>
			</div>
			
			 <div class="text-center">
         		<button type="submit" class="btn btn-primary">新增产品 </button>
			</div>
              </form>
            </div>
         </div>
          </div>
        </div><!--/.col-xs-12.col-sm-9-->

       
      </div><!--/row-->

      <jsp:include page="../common/footer.jsp" />

    </div><!--/.container-->
  </body>
</html>
