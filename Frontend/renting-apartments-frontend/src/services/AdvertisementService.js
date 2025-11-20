import axios from 'axios'

const ADVERTISEMENT_REST_API_URL = `${process.env.REACT_APP_BACKEND_URL}/api/advertisements`

class AdvertisementService{

    getAdvertisements(){
        return axios.get(ADVERTISEMENT_REST_API_URL);
    }

    getAdvertisementById(id){
        return axios.get(ADVERTISEMENT_REST_API_URL + "/" + id);
    }

    getAdvertisementsPaginatedWithParams(nextPage, size){
        return axios.get(ADVERTISEMENT_REST_API_URL+"/paginate?page="+nextPage+"&size="+size);    
    }
    

    getAdvertisementsPaginated(){
        return axios.get(ADVERTISEMENT_REST_API_URL+"/paginate");    
    }

}
export default new AdvertisementService();