angular.module('myApp').controller('BaseController', ['$scope', 'RolesService', function($scope, RolesService){
    $scope.isUpdate = false;
    $scope.isAllowed = function(role){
        return true;//RolesService.contains(role);
    }
    $scope.isAllowedAny = function(role){
        return true; //RolesService.containsAny(role);
    };
    $scope.reloadSelect2 = function() {
       	setTimeout(function() {
       	    $('select').trigger('change.select2')
   	    }, 100);
    }
}]);