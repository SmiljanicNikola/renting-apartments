import React, { useState, useEffect } from 'react'
import { InfoWrapper, Column1, TextWrapper, Subtitle, Heading, TopLine, InfoContainer, Column2, ImgWrap, InfoRow, BtnWrap, Img} from '../../elements/AdvertisementElement.js'
import { Button } from '../../elements/ButtonElement'
import apartmentImage from '../../../assets/img/apartment-one.jpg'
import AdvertisementService from '../../../services/AdvertisementService'
import ApartmentService from '../../../services/ApartmentService.js';
import { useNavigate } from 'react-router-dom'

export const Advertisements = ({lightBg,id,imgStart,topLine,lightText,headLine,description,buttonLabel,darkText,img,alt, primary,dark,dark2}) => {

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
    <>
    {advertisements.map((advertisement) => (
        <InfoContainer lightBg={lightBg} id={id}>
        <InfoWrapper>
            <InfoRow imgStart={imgStart}>
                <Column1>
                    <TextWrapper>
                        <TopLine>{advertisement.apartment.numberOfBeds} Beds, {advertisement.apartment.numberOfRooms} Rooms</TopLine>
                        <TopLine>{advertisement.apartment.petFriendly ? <p>Pet Friendly</p> : <p style={{color:'none;'}}>Pets are not allowed</p>}</TopLine>

                        <Heading><b>Adress: </b> {advertisement.apartment.address}, {advertisement.apartment.city}</Heading>
                        <Subtitle darkText={darkText}><b>{advertisement.price}</b> Din per night</Subtitle>
                        <Subtitle darkText={darkText}><b>Contact at: </b>{advertisement.email}</Subtitle>

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
                    </TextWrapper>

                </Column1>
                <Column2>
                    <ImgWrap>
                        <Img src={apartmentImage} alt={alt}/>
                    </ImgWrap>
                </Column2>
            </InfoRow>
        </InfoWrapper>
        </InfoContainer>  
    ))}
   
  </>  )
}
