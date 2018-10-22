angular.module('myApp').controller('customerCtrl',function($scope,$http){
    $scope.customer={};
    $scope.username='';

    $scope.getCustomerDetails=function () {
        var url = window.location.pathname;
        var username= url.substring(url.lastIndexOf('/')+1);
        $http.get('/mywebapp/customer/get/'+username)
            .then(function(response){
                $scope.customer=response.data;
            })
    };

    $scope.editCustomer=function(obj){
        $http.put('/mywebapp/account',obj)
            .then(function(response){
                window.location='/mywebapp/account/'+$scope.customer.login;
            })
    };

    $scope.getUsername=function(){
        var url = window.location.pathname;
        $scope.username=url.substring(url.lastIndexOf('/')+1);
    }

});