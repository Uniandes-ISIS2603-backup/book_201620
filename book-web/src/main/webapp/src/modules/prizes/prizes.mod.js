(function (ng) {
    var mod = ng.module("prizeModule", ["ngMessages",'ui.bootstrap']);

    mod.constant("prizesContext", "api/prizes");

    mod.config(['$stateProvider', '$urlRouterProvider', function ($stateProvider, $urlRouterProvider) {
            var basePath = 'src/modules/prizes/';
            $urlRouterProvider.otherwise("/prizesList");

            $stateProvider.state('prizes', {
                url: '/prizes',
                abstract: true,
                views: {
                    'mainView': {
                        controller: 'prizesCtrl',
                        controllerAs: 'ctrl',
                        templateUrl: basePath + 'prizes.html'
                    }
                }
            }).state('prizesList', {
                url: '/list',
                parent: 'prizes',
                views: {
                    'prizeView': {
                        controller: 'prizesCtrl',
                        controllerAs: 'ctrl',
                        templateUrl: basePath + 'prizes.list.html'
                    }
                }
            }).state('prizeCreate', {
                url: '/create',
                parent: 'prizes',
                views: {
                    'prizeView': {
                        controller: 'prizesCtrl',
                        controllerAs: 'ctrl',
                        templateUrl: basePath + 'prizes.create.html'
                    }
                }
            }).state('prizeEdit', {
                url: '/{prizeId:int}/edit',
                parent: 'prizes',
                views: {
                    'prizeView': {
                        controller: 'prizesCtrl',
                        controllerAs: 'ctrl',
                        templateUrl: basePath + 'prizes.create.html'
                    },
                    'childView': {
                        templateUrl: basePath + 'prizes.instance.html'
                    }
                }
            });
        }]);
})(window.angular);
