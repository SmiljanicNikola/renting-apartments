import React, { useState, useEffect } from 'react'
import { InfoWrapper, Column1, TextWrapper, Subtitle, Heading, TopLine, InfoContainer, Column2, ImgWrap, InfoRow, BtnWrap, Img} from '../../elements/AdvertisementElement.js'
import { Button } from '../../elements/ButtonElement'
import apartmentImage from '../../../assets/img/apartment-one.jpg'
import AdvertisementService from '../../../services/AdvertisementService'
import ApartmentService from '../../../services/ApartmentService.js';
import { useNavigate } from 'react-router-dom'
import AdvertiseItem from './AdvertiseItem.js'
import '../../../assets/css/advertiseItem.css'
import Pagination from '../../utils/Pagination';
import PaginationHelper from '../../utils/PaginationHelper';

export const Advertisementss = () => {


    const[advertisements, setAdvertisements] = useState([]);
    const[apartments, setApartments] = useState([]);
    const [paginatedAdvertisements, setPaginatedAdvertisements] = useState([])
    const navigate = useNavigate();
    const [size, setSize] = useState(4);
    const [currentPage, setCurrentPage] = useState(0);
	  const [advertisementsPerPage] = useState(4);

    
  const fetchPaginatedAdvertisements = async () =>{
    AdvertisementService.getAdvertisementsPaginatedWithParams(currentPage, size)
    .then(response => {
      setPaginatedAdvertisements(response.data.content);
    })
  };

    useEffect(() => {

      fetchPaginatedAdvertisements();
  
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


    const paginate = (pageNumber) => {

      setCurrentPage(pageNumber);
  
      AdvertisementService.getAdvertisements(currentPage,size)
      .then(response => {
        setPaginatedAdvertisements(response.data.content);
      })
  
    }
  
    const nextPage = async () => {
      let nextPage = currentPage + 1;
      setCurrentPage(nextPage)
  
      PaginationHelper.displayPaginated(nextPage, size, AdvertisementService.getAdvertisementsPaginatedWithParams, setPaginatedAdvertisements)
  
    }	
  
    const previousPage = async () => {
      let previousPage = currentPage - 1;
      if(currentPage < 0){
        setCurrentPage(0)
      }
      setCurrentPage(previousPage)
    
      PaginationHelper.displayPaginated(previousPage, size, AdvertisementService.getAdvertisementsPaginatedWithParams, setPaginatedAdvertisements)
  
  
    }

  return (
    <>
   
    <div className='cards'>
        <div class="grey-box-wrap reports">          
          <div class="search-page">
            <p>City: </p><input type="search" name="search-clients" className="in-search" />
            <p>Address: </p><input type="search" name="search-clients" className="in-search" />
            <p>Min Price: </p><input type="search" name="search-clients" className="in-search-number" />
            <p>Max Price: </p><input type="search" name="search-clients" className="in-search-number" />
          </div>
        </div>
        <div className="link new-member-popup">Create new Advertisement</div>

       
    
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

            <h1>Check out other offers</h1>
            <ul className="cards__items">
                {paginatedAdvertisements.map((advertisement) => (
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

  <div class="pagination">
        <ul>
          <li>
            <button onClick={previousPage}>Previous</button>
          </li>
          <li>
            <Pagination
              clientsPerPage={advertisementsPerPage}
              totalClients={advertisements.length}
              paginate={paginate}
            />
          </li>
          <li>
            <button onClick={nextPage}>
              Next
            </button>
          </li>
        </ul>
    </div>
</>
  )
}
