(function (ng) {
    var mod = ng.module("authorModule", ["ngMessages",'ui.bootstrap']);

    mod.constant("authorsContext", "api/authors");

    mod.config(['$stateProvider', '$urlRouterProvider', function ($stateProvider, $urlRouterProvider) {
            var basePath = 'src/modules/authors/';
            $urlRouterProvider.otherwise("/authorsList");

            $stateProvider.state('authors', {
                url: '/authors',
                abstract: true,
                views: {
                    'mainView': {
                        controller: 'authorsCtrl',
                        controllerAs: 'ctrl',
                        templateUrl: basePath + 'authors.html'
                    }
                }
            }).state('authorsList', {
                url: '/list',
                parent: 'authors',
                views: {
                    'authorView': {
                        controller: 'authorsCtrl',
                        controllerAs: 'ctrl',
                        templateUrl: basePath + 'authors.list.html'
                    }
                }
            }).state('authorCreate', {
                url: '/create',
                parent: 'authors',
                views: {
                    'authorView': {
                        controller: 'authorsCtrl',
                        controllerAs: 'ctrl',
                        templateUrl: basePath + 'authors.create.html'
                    }
                }
            }).state('authorEdit', {
                url: '/{authorId:int}/edit',
                parent: 'authors',
                views: {
                    'authorView': {
                        controller: 'authorsCtrl',
                        controllerAs: 'ctrl',
                        templateUrl: basePath + 'authors.create.html'
                    },
                    'childView': {
                        templateUrl: basePath + 'authors.instance.html'
                    }
                }
            }).state('authorBooksList', {
                url: '/bookss/list',             
                parent: 'authorEdit',
                views: {                 
                    'authorInstanceView': {
                        controller: 'authorsBookCtrl',
                        controllerAs: 'ctrl',
                        templateUrl: basePath + 'authorsbooks/' + 'authorsBook.list.html'
                    }
                }
            }).state('authorPrizeEdit', {
                url: '/prizes/edit',             
                parent: 'authorEdit',
                views: {                 
                    'authorInstanceView': {
                        controller: 'authorsPrizeCtrl',
                        controllerAs: 'ctrl',
                        templateUrl: basePath + 'authorsprizes/' + 'authorsPrize.edit.html'
                    }
                }
            });
        }]);
})(window.angular);
