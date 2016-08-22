<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML>
<html>
  <head>
	<jsp:include page="../common/meta.jsp" />
	<jsp:include page="../common/resources.jsp" />
	<script src="${path }/scripts/demo/portal.js" ></script>
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
              <h3 class="panel-title">客户管理</h3>
            </div>
            <div class="panel-body">
            
            <div class="row">
            <form class="form" role="form">
            <div class="col-md-4">
              	<div class="form-group">
				    <div class="input-group">
				      <div class="input-group-addon">&nbsp;姓&nbsp;&nbsp;名</div>
				      <input class="form-control" type="text" placeholder="请输入客户姓名">
				    </div>
				  </div>
			</div>
			 <div class="col-md-4">
				  <div class="form-group">
				    <div class="input-group">
				      <div class="input-group-addon">证件号</div>
				      <input class="form-control" type="text" placeholder="请输入证件号">
				    </div>
				  </div>
			</div>
			 <div class="col-md-4">
				  <div class="form-group">
				    <div class="input-group">
				      <div class="input-group-addon">手机号</div>
				      <input class="form-control" type="text" placeholder="请输入手机号">
				    </div>
				  </div>
			</div>
			 <div class="col-md-4">
				  <div class="form-group">
				    <div class="input-group">
				      <div class="input-group-addon">&nbsp;性&nbsp;&nbsp;别</div>
					     <select class="form-control">
						  <option>男</option>
						  <option>女</option>
						</select>
				    </div>
				  </div>
			</div>
			<div class="col-md-1">
			<button type="button" class="btn btn-primary">搜索</button>  
			</div>	
			<div class ="col-md-3">
			<div class="checkbox">
			  <label>
			    <input type="checkbox" value="">
			    仅看已绑定客户
			  </label>
			</div>
			</div>
			  
              </form>
            </div>
         </div>
          </div>
          <div class="row">
          <div class="col-xs-12">
          <div class="table-responsive">
            <table class="table table-striped table-hover">
              <thead>
                <tr>
                  <th>#</th>
                  <th>Header</th>
                  <th>Header</th>
                  <th>Header</th>
                  <th>Header</th>
                </tr>
              </thead>
              <tbody>
                <tr>
                  <td>1,001</td>
                  <td>Lorem111111111111111111111111111111111111111111111111111</td>
                  <td>ipsum1111111111111111111111111111111111111111111111111</td>
                  <td>dolor11111111111111111111111111111111111111111111111</td>
                  <td>sit</td>
                </tr>
                <tr>
                  <td>1,002</td>
                  <td>amet</td>
                  <td>consectetur</td>
                  <td>adipiscing</td>
                  <td>elit</td>
                </tr>
                <tr>
                  <td>1,003</td>
                  <td>Integer</td>
                  <td>nec</td>
                  <td>odio</td>
                  <td>Praesent</td>
                </tr>
                <tr>
                  <td>1,003</td>
                  <td>libero</td>
                  <td>Sed</td>
                  <td>cursus</td>
                  <td>ante</td>
                </tr>
                <tr>
                  <td>1,004</td>
                  <td>dapibus</td>
                  <td>diam</td>
                  <td>Sed</td>
                  <td>nisi</td>
                </tr>
                <tr>
                  <td>1,005</td>
                  <td>Nulla</td>
                  <td>quis</td>
                  <td>sem</td>
                  <td>at</td>
                </tr>
                <tr>
                  <td>1,006</td>
                  <td>nibh</td>
                  <td>elementum</td>
                  <td>imperdiet</td>
                  <td>Duis</td>
                </tr>
                <tr>
                  <td>1,007</td>
                  <td>sagittis</td>
                  <td>ipsum</td>
                  <td>Praesent</td>
                  <td>mauris</td>
                </tr>
                <tr>
                  <td>1,008</td>
                  <td>Fusce</td>
                  <td>nec</td>
                  <td>tellus</td>
                  <td>sed</td>
                </tr>
                <tr>
                  <td>1,009</td>
                  <td>augue</td>
                  <td>semper</td>
                  <td>porta</td>
                  <td>Mauris</td>
                </tr>
                <tr>
                  <td>1,010</td>
                  <td>massa</td>
                  <td>Vestibulum</td>
                  <td>lacinia</td>
                  <td>arcu</td>
                </tr>
                <tr>
                  <td>1,011</td>
                  <td>eget</td>
                  <td>nulla</td>
                  <td>Class</td>
                  <td>aptent</td>
                </tr>
                <tr>
                  <td>1,012</td>
                  <td>taciti</td>
                  <td>sociosqu</td>
                  <td>ad</td>
                  <td>litora</td>
                </tr>
                <tr>
                  <td>1,013</td>
                  <td>torquent</td>
                  <td>per</td>
                  <td>conubia</td>
                  <td>nostra</td>
                </tr>
                <tr>
                  <td>1,014</td>
                  <td>per</td>
                  <td>inceptos</td>
                  <td>himenaeos</td>
                  <td>Curabitur</td>
                </tr>
                <tr>
                  <td>1,015</td>
                  <td>sodales</td>
                  <td>ligula</td>
                  <td>in</td>
                  <td>libero</td>
                </tr>
              </tbody>
            </table>
          </div>
          <div class="text-center">
          <nav>
		  <ul class="pagination">
		    <li class="disabled"><a href="#">&laquo;</a></li>
		    <li class="active"><a href="#">1 <span class="sr-only">(current)</span></a></li>
		  	<li><a href="#">&raquo;</a></li>
		  </ul>
		</nav>
		</div>
          </div>
          </div><!--/row-->
        </div><!--/.col-xs-12.col-sm-9-->

       
      </div><!--/row-->

      <jsp:include page="../common/footer.jsp" />

    </div><!--/.container-->
    
  </body>
</html>
