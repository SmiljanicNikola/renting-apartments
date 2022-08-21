import React, { useState, useEffect } from 'react'
import { InfoWrapper, Column1, TextWrapper, Subtitle, Heading, TopLine, InfoContainer, Column2, ImgWrap, InfoRow, BtnWrap, Img} from '../../elements/AdvertisementElement.js'
import { Button } from '../../elements/ButtonElement'
import apartmentImage from '../../../assets/img/apartment-one.jpg'
import AdvertisementService from '../../../services/AdvertisementService'
import ApartmentService from '../../../services/ApartmentService.js';
import { useNavigate } from 'react-router-dom'
import AdvertiseItem from './AdvertiseItem.js'
import '../../../assets/css/advertiseItem.css'

export const Advertisementss = () => {


    const[advertisements, setAdvertisements] = useState([]);
    const[apartments, setApartments] = useState([]);
    const navigate = useNavigate();
  
    useEffect(() => {
  
      AdvertisementService.getAdvertisements().then(response => {
              setAdvertisements(response.data);
        console.log(advertisements);
          })
  
      ApartmentService.getApartments().then(response => {
              setApartments(response.data);
          })
  
    }, []);
  
    const sendRentRequest = () =>{
      navigate('/rentRequest');
    }

  return (
   
    <div className='cards'>
        
       
    
    <div className="cards__container">
        <div className="cards__wrapper">
        <h1>Check out our last minute offers</h1>
            <ul className="cards__items">
                <AdvertiseItem 
                src={apartmentImage}
                text="Check out this offer and save money for yourself"
                label='Last minute action'
               
                path='/apartments'
                />
                <AdvertiseItem 
                src={apartmentImage}
                text="Check out this offer and save money for yourself"
                label="Last minute action"
                path='/services'
                />
                    
            </ul>

            <h1>Check out others</h1>
            <ul className="cards__items">
                {advertisements.map((advertisement) => (
                    <div className="item-button-box">
                    <AdvertiseItem 
                    src={apartmentImage}
                    text={advertisement.apartment.address + ", " + advertisement.apartment.city}
                    text1={"$"+advertisement.price + " per night"}
                    text2={advertisement.apartment.numberOfBeds + " Beds , " + advertisement.apartment.numberOfRooms + " Rooms."}
                    label={advertisement.apartment.petFriendly ? "Pet Friendly" : "Pets Are not allowed"}
                    path='/services'

                    
                    />
                    <BtnWrap>
                        <Button
                        onClick={sendRentRequest}
                        smooth={true}
                        duration={500}
                        spy={true}
                        exact="true"
                        offset={-80}
                        
                        >Send Request</Button>
                            
                    </BtnWrap>
                    </div>
                ))}
                
            </ul>
           
        </div>
        
    </div>
  
</div>

  

  )
}
