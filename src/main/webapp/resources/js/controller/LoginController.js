
var myApp = angular.module('myApp',[]);
myApp.controller('loginCtrl', function($scope,$http){
    $scope.credentials={};
    $scope.credentials.username='';
    $scope.credentials.password='';

    $scope.sendCredentials = function(credentials){
        var config = {headers: {'Content-Type': 'application/x-www-form-urlencoded'}};
        $http.post('/mywebapp/login',"username="+credentials.username+"&password="+credentials.password,config)
            .then(function successCallback(reponse){
                $scope.credentials.username='';
                $scope.credentials.password='';
                //window.location='/mywebapp/';
            });

    };

});