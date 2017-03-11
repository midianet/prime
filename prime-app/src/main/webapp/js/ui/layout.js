'use strict';
angular.module('myApp.layout', ['ngRoute'])
	.controller('LayoutCtrl', ['$scope', 'acessos', function ($scope, acessos) {
		$scope.acessos = acessos;
		Prism.highlightAll();
		$('#myTab a').click(function (e) {
			e.preventDefault();
		});
}]);