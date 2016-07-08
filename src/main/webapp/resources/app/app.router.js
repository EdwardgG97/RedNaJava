angular
	.module("app")
	.config(RouteConfig);

RouteConfig.$inject = ['$routeProvider'];
function RouteConfig($routeProvider){
	$routeProvider
		.when('/', {template: '<login></login>'})
		.when('/login', {template: '<login></login>'})
		.when('/forget-password', {template: '<forget></forget>'})
		.when('/create-account', {template: '<create-account></create-account>'})
		.when('/dashboard', {template: '<dashboard></dashboard>'})
		.otherwise({redirectTo: '/'});
}