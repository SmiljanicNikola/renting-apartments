import axios from 'axios'

const APARTMENTS_REST_API_URL = `${process.env.REACT_APP_BACKEND_URL}/api/apartments`

class ApartmentService{

    getApartments(){
        return axios.get(APARTMENTS_REST_API_URL);
    }

}

export default new ApartmentService();