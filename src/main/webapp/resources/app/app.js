angular
	.module("app", ['ngRoute'])
	.run(Runner)
	.value("API_URL", window.location.origin + '/app/api');

Runner.$inject = ['$rootScope'];
function Runner($rootScope){
	$rootScope.contain = true;
	$rootScope.userData = {
			userEmail: "",
			userId: 0
	};
}