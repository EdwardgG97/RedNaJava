angular
	.module("app")
	.service("LoginService", LoginService);

LoginService.$inject = ['$http', 'API_URL', '$q'];
function LoginService($http, API_URL, $q){
	return {
		getAuth: getAuth
	};
	
	function getAuth(data){
		var deferred = $q.defer();
		$http.post(API_URL + "/auth", data)
		     .then(d => deferred.resolve(d.data))
		     .catch(e => deferred.reject(e));
		return deferred.promise;
	}
}