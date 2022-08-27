import axios from 'axios'

const APARTMENTS_REST_API_URL = `${process.env.REACT_APP_BACKEND_URL}/api/apartments`

class ApartmentService{

    getApartments(){
        return axios.get(APARTMENTS_REST_API_URL);
    }

    getApartmentsPaginatedWithParams(nextPage, size){
        return axios.get(APARTMENTS_REST_API_URL+"/paginate?page="+nextPage+"&size="+size);    
    }

    getApartmentsPaginated(){
        return axios.get(APARTMENTS_REST_API_URL+"/paginate");    
    }

}

export default new ApartmentService();