<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
	<head>
		<title>CMS</title>
		<meta charset="UTF-8" />
		<c:url value="/resources/js" var="js"></c:url>
		<c:url value="/resources/app" var="app"></c:url>
		<c:url value="/resources/css" var="css"></c:url>
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
  		<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.97.6/css/materialize.min.css">
  		<script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.97.6/js/materialize.min.js"></script>
		<link href="${ css }/style.css" rel="stylesheet" />
		<script type="text/javascript" src="${ js }/angular.js"></script>
		<script type="text/javascript" src="${ js }/angular-route.js"></script>
		<script type="text/javascript" src="${ js }/angular-animate.js"></script>
		<!-- App -->
		<script type="text/javascript" src="${ app }/app.js?1"></script>
		<script type="text/javascript" src="${ app }/services/login.service.js"></script>
		<script type="text/javascript" src="${ app }/components/login.component.js?2"></script>
		<script type="text/javascript" src="${ app }/components/forgetPass.component.js?2"></script>
		<script type="text/javascript" src="${ app }/components/createAccount.component.js?2"></script>
		<script type="text/javascript" src="${ app }/app.router.js?1"></script>
	</head>
	<body ng-app="app">
		<section ng-class="contain ? 'container' : '' ">
			<ng-view></ng-view>
		</section>
	</body>
</html>
