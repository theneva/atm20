angular.module('atmApp')
    .factory('DirectDebitPayment', ['$http', 'Account', 'ServiceAPI', function ($http, Account, ServiceAPI) {

        return {
            cancelPayment: function (id) {
                $http({
                    url: ServiceAPI.url + '/api/payments/' + id,
                    method: 'DELETE',
                    headers: {
                        Authorization: Account.getToken()
                    }
                });
            }
        }
    }]);