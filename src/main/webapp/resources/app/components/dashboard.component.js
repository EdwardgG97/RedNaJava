angular
	.module("app")
	.component("dashboard", {
		templateUrl: "/app/resources/app/templates/dashboard.template.html",
		controller: DashBoardController
	});

DashBoardController.$inject = ['$rootScope'];
function DashBoardController($rootScope){
	var vm = this;
	vm.sessionModel = {
			userEmail: $rootScope.userData.userEmail,
			userId: $rootScope.userData.userId,
			userCompleteName: $rootScoppe.userdata.userCompleteName
	}
}