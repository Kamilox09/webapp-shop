
var myApp = angular.module('myApp',[]);
myApp.controller('loginCtrl', function($scope,$http){
    $scope.credentials={};
    $scope.credentials.username='';
    $scope.credentials.password='';

    $scope.sendCredentials = function(credentials){
        var config = {headers: {'Content-Type': 'application/x-www-form-urlencoded'}};
        $http.post('/mywebapp/login',"username="+credentials.username+"&password="+credentials.password,config)
            .then(function successCallback(reponse){
                $scope.reset();
                window.location='/mywebapp';
            },
                failureCallback());
    };

    var successCallback = function(response){
        $scope.reset();
        window.location='/mywebapp/';
    };

    var failureCallback = function(){
        $scope.reset();
        $scope.setError('Nieprawidłowy login lub hasło');
    };

    $scope.reset = function(){
        $scope.error=false;
        $scope.errorMsg='';
        $scope.credentials={};
        $scope.credentials.username='';
        $scope.credentials.password='';
    }

    $scope.setError=function(msg){
        $scope.error=true;
        $scope.errorMsg=msg;
    }

});