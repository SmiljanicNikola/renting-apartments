import axios from 'axios'

const ADVERTISEMENT_REST_API_URL = `${process.env.REACT_APP_BACKEND_URL}/api/advertisements`

class AdvertisementService{

    getAdvertisements(){
        return axios.get(ADVERTISEMENT_REST_API_URL);
    }

}
export default new AdvertisementService();