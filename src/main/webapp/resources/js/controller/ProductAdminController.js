var myApp = angular.module('myApp',[]);
myApp.controller('productAdminCtrl',function($scope,$http){
    $scope.obj={};
    $scope.obj.name='';
    $scope.error=false;
    $scope.products={};
    $scope.old={};




    $scope.addProduct = function(obj){
        $http.post('/mywebapp/admin/product',obj)
            .then(function(){
                $scope.reset();
                window.location='/mywebapp/admin/product';
            })
            .catch(function(){failureCallback();
            })
    };


    $scope.editProduct = function(obj){
        $scope.obj.productId=$scope.old.productId;
        $http.put('/mywebapp/admin/product',obj)
            .then(function(){
                $scope.reset();
                window.location='/mywebapp/admin/product';
            })
            .catch(function(){
                failureCallback();
            })
    };


    $scope.getAllProducts = function(){
        $http.get('/mywebapp/admin/product/all')
            .then(function(data){
                $scope.products=data.data;
            })
    };

    $scope.getOld = function(){
        var url = window.location.pathname;
        var id= url.substring(url.lastIndexOf('/')+1);
        $http.get('/mywebapp/admin/product/get/'+id)
            .then(function(response){
                $scope.old=response.data;
                $scope.obj.name=$scope.old.name;
            })

    };

    $scope.reset=function(){
        $scope.obj={};
        $scope.obj.name='';
        $scope.error=false;
        $scope.old={};

    };

    var failureCallback = function(){
        $scope.error=true;
    }
});