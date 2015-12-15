App.factory('СategoryService', ['$http', '$q', function($http, $q){

    return {

        fetchAllCategories: function() {
            return $http.get('http://localhost:8080/rest/categories/')
                .then(
                function(response){
                    return response.data;
                },
                function(errResponse){
                    console.error('Error while fetching categories');
                    return $q.reject(errResponse);
                }
            );
        },

        fetchCategory: function(id){
            return $http.get('http://localhost:8080/rest/categories/'+id)
                .then(
                function(response){
                    return response.data;
                },
                function(errResponse){
                    console.error('Error while fetching category');
                    return $q.reject(errResponse);
                }
            );
        },

        createCategory: function(category){
            return $http.post('http://localhost:8080/rest/categories/category', category)
                .then(
                function(response){
                    return response.data;
                },
                function(errResponse){
                    console.error('Error while creating category');
                    return $q.reject(errResponse);
                }
            );
        },

        updateCategory: function(category, id){
            return $http.put('http://localhost:8080/rest/categories/'+id, category)
                .then(
                function(response){
                    return response.data;
                },
                function(errResponse){
                    console.error('Error while updating category');
                    return $q.reject(errResponse);
                }
            );
        },

        deleteCategory: function(id){
            return $http.delete('http://localhost:8080/rest/categories/'+id)
                .then(
                function(response){
                    return response.data;
                },
                function(errResponse){
                    console.error('Error while deleting category');
                    return $q.reject(errResponse);
                }
            );
        }

    };

}]);