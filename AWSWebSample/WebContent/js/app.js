'use strict';
var myApp = angular.module('myApp', []);

myApp.controller("forgotPwdCtrl", ['$scope', '$http', function ($scope, $http) {

    $scope.login = function () {

        $http({
            method: 'POST',
            url: 'reset',
            data: $.param({email: $scope.email}),
            headers: {'Content-Type': 'application/x-www-form-urlencoded'}
        }).then(function (resp) {
            alert(resp)
        });
    }
}]);

myApp.controller("signupCtrl", ['$scope', '$http', function ($scope, $http) {

    $scope.signup = function () {

        $http({
            method: 'POST',
            url: 'signup',
            data: $.param({
            		id: $scope.id, 
	            	email: $scope.email, 
	            	password: $scope.password,
	            	name: $scope.name,
	            	city: $scope.city,
	            	zip: $scope.zip, 
	            	phone1: $scope.phone1,
	            	phone2: $scope.phone2,
	            	address: $scope.address,
	            	state: $scope.state
            	}),
            headers: {'Content-Type': 'application/x-www-form-urlencoded'}
        }).then(function (resp) {
            alert(resp.data.message)
        });
    }
}]);

myApp.controller("loginCtrl", ['$scope', '$http', function ($scope, $http) {

    $scope.login = function () {

        $http({
            method: 'POST',
            url: 'login',
            data: $.param({email: $scope.email, password: $scope.password}),
            headers: {'Content-Type': 'application/x-www-form-urlencoded'}
        }).then(function (resp) {
            alert(resp.data.message)
        });
    }
}]);