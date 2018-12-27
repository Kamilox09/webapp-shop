angular.module('myApp').controller('cartCtrl',function($scope,$http) {
    $scope.lines = {};
    $scope.cart={};
    $scope.error=false;


    $scope.checkCartAndGetLines = function () {
        $http.get("/mywebapp/cart/check")
            .then(function(response) {
                $scope.cart=response.data;

                $http.get('/mywebapp/cart/getlines/'+$scope.cart.cartId)
                    .then(function(response){
                        $scope.lines=response.data;
                    })
            })
    };

    $scope.deleteOrderLine = function(id){
      $http.delete('/mywebapp/cart?id='+id)
          .then(function(){
             /* var i,ind;
              for(i=0;$scope.lines.length;i++){
                if($scope.lines[i].orderLineId===id){
                    ind=i;
                    break;
                }
              }
              $scope.lines.splice(ind,1);*/
              $scope.checkCartAndGetLines();
          })
    };

    $scope.updateOrderLine = function(obj){
        $scope.error=false;
        if(obj.quantity<=obj.product.quantity && obj.quantity>0) {
            $http.put('/mywebapp/updateitem', obj)
                .then(function () {
                    $scope.checkCartAndGetLines();
                })
                .catch(function () {
                    $scope.error = true;
                })
        }else if(obj.quantity>obj.product.quantity){
            obj.quantity=obj.product.quantity;
        } else if(obj.quantity<=0){
            obj.quantity=1;
        }
    };

    $scope.pressBuy = function(){
        $http.get('/mywebapp/cart/buy');
        window.location='/mywebapp/cart'

    };



});