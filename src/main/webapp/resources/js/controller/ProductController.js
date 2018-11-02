angular.module('myApp').controller('productCtrl',function($scope,$http) {

    $scope.products={};
    $scope.page=1;
    $scope.amountOfProducts=0;
    $scope.categoryName="";
    $scope.amountOfPages=0;
    $scope.newPage='';


    $scope.getAmountOfProducts=function(){
        if($scope.categoryName==="") {
            $http.get('/mywebapp/productcount')
                .then(function (response) {
                    $scope.amountOfProducts = response.data;
                    countAmountOfPages();
                })
        }else{
            $http.get('/mywebapp/productcount/'+$scope.categoryName)
                .then(function(response){
                    $scope.amountOfProducts=response.data;
                    countAmountOfPages();
                })
        }

    };

    $scope.getPageOfProducts=function(){
        $scope.getAmountOfProducts();
        //countAmountOfPages();
        if($scope.categoryName==="") {
            $http.get('/mywebapp/products/get?page=' + $scope.page)
                .then(function (response) {
                    $scope.products = response.data;
                })
        }else{
            $http.get('/mywebapp/products/get?page=' + $scope.page+"&category="+$scope.categoryName)
                .then(function (response) {
                    $scope.products = response.data;
                })
        }
    };

    $scope.setCategory=function(name){
        if(window.location.pathname!== '/mywebapp/products')
            window.location='/mywebapp/products';
        $scope.categoryName=name;
        $scope.products={};
        $scope.getPageOfProducts();

    };

     var countAmountOfPages = function(){
        $scope.amountOfPages = Math.ceil($scope.amountOfProducts/15);
    };

     $scope.getNextPreviousPage = function(n){
         $scope.page=$scope.page+n;
         $scope.getPageOfProducts();
     };

     $scope.setNewPage=function(){
       if(parseInt($scope.newPage)>0 && parseInt($scope.newPage)<=$scope.amountOfPages){
           $scope.page=parseInt($scope.newPage);
           $scope.newPage='';
           $scope.getPageOfProducts();
       }
     };



});