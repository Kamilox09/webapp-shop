angular.module('myApp').controller('productCtrl',function($scope,$http,$location) {

    $scope.products={};
    $scope.page=1;
    $scope.amountOfProducts=0;
    $scope.categoryName="";
    $scope.amountOfPages=0;
    $scope.newPage='';
    $scope.productDetail={};
    $scope.productDetailPhotos=[];
    $scope.ifPhoto=false;
    $scope.firstPhoto={};
    $scope.logged=false;
    $scope.productQuantity=1;
    $scope.added=false;
    $scope.error=false;


    $scope.getUser=function () {
        $http.get('/mywebapp/sessiondetails')
            .then(function(response){
                var username=response.data.username;
                if(username!==""){
                    $scope.logged=true;
                }else{
                    $scope.logged=false;
                }
            })
    };


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
        $scope.setCategory();
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

    $scope.setCategory=function(){
        var loc=location.search;
        var name=loc.substring(loc.lastIndexOf('=')+1);
        $scope.categoryName=name;
        $scope.products={};
        //console.log(name);
        //$scope.getPageOfProducts();

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

     $scope.getProduct = function(){
         var url=window.location.pathname;
         var prId = url.substring(url.lastIndexOf('/')+1);
        $http.get('/mywebapp/product/get/'+prId)
            .then(function(response){
                $scope.productDetailPhotos=[];
                $scope.firstPhoto=[];
                $scope.productDetail=response.data;
                $scope.productDetailPhotos=Object.create(response.data.photoList);
                $scope.productDetailPhotos.length===0?$scope.ifPhoto=false:$scope.ifPhoto=true;
                if($scope.ifPhoto){
                    $scope.firstPhoto=$scope.productDetailPhotos.splice(0,1);
                }

            })
     };

     $scope.addToCart = function (prodQuantity) {
         $scope.added=false;
         $scope.error=false;
        var obj = {};
        obj.productId = $scope.productDetail.productId;
        obj.quantity=prodQuantity;
        console.log(obj.quantity);
        $http.post('/mywebapp/additem',obj)
            .then(function(){
                $scope.added=true;
            })
            .catch(function () {
                $scope.error=true;
            })
     };







});