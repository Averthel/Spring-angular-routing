angular.module('app2', []).controller('CommentController', function($http) {
    var vm = this;
    function refreshData() {
        $http({
            method : 'GET',
            url : 'api/comments'
        }).then(function success(response) {
            vm.comments = response.data;
            console.log(vm.comments);
        }, function error(response) {
            console.log('API error ' + response.status);
        });
    }

    vm.addComment = function(comment) {
        $http({
            method : 'POST',
            url : 'api/comments',
            data : comment
        }).then(function success(response) {
            refreshData2();
            vm.comment = {};
        }, function error(response) {
            console.log('Data not saved ' + comment);
        });
    }

    vm.appName = 'Product Manager';
    refreshData();
});
