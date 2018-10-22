angular.module('myApp').controller('customerCtrl',function($scope,$http){
    $scope.customer={};
    $scope.username='';
    $scope.error=false;
    $scope.success=false;
    $scope.pass={};
    $scope.pass.old='';
    $scope.pass.new='';
    $scope.check='';

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
    };

    $scope.changePassword=function (obj) {
        $http.put('/mywebapp/changepassword/'+$scope.username,obj)
            .then(function(response){
                $scope.success=true;
                $scope.error=false;
                $scope.pass={};
                $scope.pass.old='';
                $scope.pass.new='';
                $scope.check='';
            })
            .catch(function(){
                $scope.error=true;
                $scope.success=false;
                $scope.pass={};
                $scope.pass.old='';
                $scope.pass.new='';
                $scope.check='';
            })

    };

});