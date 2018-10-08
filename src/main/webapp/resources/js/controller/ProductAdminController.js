//var myApp = angular.module('myApp',[]);
angular.module('myApp').controller('productAdminCtrl',function($scope,$http){
    $scope.obj={};
    $scope.obj.name='';
    $scope.obj.description='';
    $scope.obj.netPrice=0.0;
    $scope.obj.grossPrice=0.0;
    $scope.obj.vat=0.0;
    $scope.obj.quantity=0;
    $scope.obj.active=true;
    $scope.obj.manufacturer={};
    $scope.obj.manufacturer.name='';
    $scope.obj.category={};
    $scope.obj.category.name='';
    $scope.error=false;
    $scope.products={};
    $scope.old={};


    $scope.getAddProductPage = function () {
        window.location='/mywebapp/admin/product/add'
    };

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
        $scope.obj.description='';
        $scope.obj.netPrice=0.0;
        $scope.obj.grossPrice=0.0;
        $scope.obj.vat=0.0;
        $scope.obj.quantity=0;
        $scope.obj.active=true;
        $scope.obj.manufacturer={};
        $scope.obj.manufacturer.name='';
        $scope.obj.category={};
        $scope.obj.category.name='';
        $scope.error=false;
        $scope.old={};

    };

    var failureCallback = function(){
        $scope.error=true;
    }
});