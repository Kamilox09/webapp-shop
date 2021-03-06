angular.module('myApp').controller('addressCtrl',function($scope,$http){
    $scope.address={};
    $scope.login="";

    $scope.getAddressDetails=function () {
        var url = window.location.pathname;
        var username= url.substring(url.lastIndexOf('/')+1);
        $scope.login=username;
        $http.get('/mywebapp/address/get/'+username)
            .then(function(response){
                $scope.address=response.data;
            })
    };

    $scope.editAddress=function(obj){
        $http.put('/mywebapp/address',obj)
            .then(function(response){
                window.location='/mywebapp/account/'+$scope.login;
            })
    };

});