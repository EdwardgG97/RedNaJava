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
	vm.loginResponse = {
			response: "",
			status: 0,
			email: "",
			id: 0
	}
	
	function authenticate(){
		if(!vm.loginModel.email){
			Materialize.toast('Email field is empty!', 3000, 'rounded red');
		}else if(!vm.loginModel.pass){
			Materialize.toast('Password field is empty!', 3000, 'rounded red');
		}else{
			LoginService.getAuth(vm.loginModel)
						.then(data => {
							console.log(data);
							vm.loginResponse.response = data.response;
							vm.loginResponse.status = data.status;
							vm.loginResponse.email = data.userEmail;
							vm.loginResponse.id = data.userId;
						})
						.catch(error => console.log(error));
			if(vm.loginResponse.response == "ok" && vm.loginResponse.status == 200){
				$rootScope.contain = false;
				$rootScope.userData.userEmail = vm.loginResponse.email;
				$rootScope.userData.userId = vm.loginResponse.id;
				$location.path('/dashboard');
			}else
				Materialize.toast('Email or Password are not correct!', 3000, 'rounded red');
		}
	}
}