//var myApp = angular.module('myApp',[]);
angular.module('myApp').controller('productAdminCtrl',function($scope,$http){
    $scope.product={};
    $scope.product.name='';
    $scope.product.description='';
    $scope.product.netPrice=0.0;
    $scope.product.grossPrice=0.0;
    $scope.product.vat=0.0;
    $scope.product.quantity=0;
    $scope.product.active=true;
    $scope.product.manufacturer={};
    $scope.product.manufacturer.name='';
    $scope.product.category={};
    $scope.product.category.name='';
    $scope.error=false;
    $scope.products={};
    $scope.old={};


    $scope.getAddProductPage = function () {
        window.location='/mywebapp/admin/product/add'
    };

    $scope.addProduct = function(product){
        $http.post('/mywebapp/admin/product',product)
            .then(function(){
                $scope.reset();
                window.location='/mywebapp/admin/product';
            })
            .catch(function(){failureCallback();
            })
    };


    $scope.editProduct = function(product){
        //$scope.product.productId=$scope.old.productId;
        $http.put('/mywebapp/admin/product',product)
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
                $scope.product=$scope.old;
            })

    };

    $scope.reset=function(){
        $scope.product={};
        $scope.product.name='';
        $scope.product.description='';
        $scope.product.netPrice=0.0;
        $scope.product.grossPrice=0.0;
        $scope.product.vat=0.0;
        $scope.product.quantity=0;
        $scope.product.active=true;
        $scope.product.manufacturer={};
        $scope.product.manufacturer.name='';
        $scope.product.category={};
        $scope.product.category.name='';
        $scope.error=false;
        $scope.old={};

    };

    var failureCallback = function(){
        $scope.error=true;
    }
});