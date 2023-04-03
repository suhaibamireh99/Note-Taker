// import axios from "axios";
import axios from "axios";
import http from "../http-common";
import authHeader from './authJwt/auth-header';

const API_URL = 'http://localhost:8080/api/v1/';

class NoteDataService {
    getAll(params) {
      console.log({authHeader})
        return http.get(API_URL + `notes/pageData`, { headers: authHeader(),
          params: {"page": params.page,
            "size":params.size,
            "searchTitle":params.searchTitle
        }});
    }

    get(id) {
        return http.get(API_URL+ `note/${id}`, { headers: authHeader() });
      }

    create(data){
        return http.post(API_URL + `note`, data, { headers: authHeader() });
    }

    // update(id, data) {
    //     return http.put(`/v1/notes/${id}`, data);
    //   }


    delete(id) {
        return http.delete(`/v1/${id}`,{ headers: authHeader() })
    }


    // deleteAll() {
    //     return http.delete(`/notes`,{ headers: authHeader() });
    //   }

    // findByTitle(title) {
    // return http.get(`/v1/notes?searchTitle=${title}`);
    // }
}
export default new NoteDataService();