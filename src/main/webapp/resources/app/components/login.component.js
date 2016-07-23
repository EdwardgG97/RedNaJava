angular
	.module("app")
	.component("login", {
		templateUrl: "/app/resources/app/templates/login.template.html",
		controller: LoginController
	});

LoginController.$inject = ['$rootScope', 'LoginService', '$location'];
function LoginController($rootScope, LoginService, $location){
	var vm = this;
	
	vm.loginModel = {
		email: "",
		pass: ""
	}
	
	vm.authenticate = authenticate;
	
	function authenticate(){
		$(".loader").fadeIn();
		if(!vm.loginModel.email){
			Materialize.toast('Email field is empty!', 3000, 'rounded red');
		}else if(!vm.loginModel.pass){
			Materialize.toast('Password field is empty!', 3000, 'rounded red');
		}else{
			LoginService.getAuth(vm.loginModel)
						.then(data => {
							if(data.response == "ok" && data.status == 200){
								$rootScope.contain = false;
								$rootScope.userData.userEmail = data.userEmail;
								$rootScope.userData.userId = data.userId;
								$rootScope.userData.userCompleteName = data.userCompleteName;
								$location.path('/dashboard');
							}else
								Materialize.toast('Email or Password are not correct!', 3000, 'rounded red');
						})
						.catch(error => {
							console.log(error);
							Materialize.toast('' + error, 3000, 'rounded red');
						})
						.finally(() => $(".loader").fadeOut());
		}
	}
}