angular.module('atmApp')
    .factory('Authentication', ['$http', 'ServiceAPI', function ($http, ServiceAPI)
    {
        return {
            verify: function (accountNumber, pinNumber)
            {

                var account = {
                    accountNumber: accountNumber,
                    pin: pinNumber
                };

                return $http.post(ServiceAPI.url + '/api/sessions', account);
            },
            destroySession: function (token) {
                return $http({
                    url: ServiceAPI.url + '/api/sessions',
                    method: 'DELETE',
                    headers: {
                        Authorization: token
                    }
                });
            }
        }
    }]);