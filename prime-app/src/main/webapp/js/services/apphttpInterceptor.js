angular.module('myApp').factory('apphttpInterceptor', function ($q, $rootScope, $timeout) {
    return {
        request: function(config) {
            return config;
        },
        requestError: function(rejection) {
            return $q.reject(rejection);
        },
        response: function(response) {
            return response;
        },
        responseError : function(rejection) {
            return $q.reject(rejection);
        }
    };
});