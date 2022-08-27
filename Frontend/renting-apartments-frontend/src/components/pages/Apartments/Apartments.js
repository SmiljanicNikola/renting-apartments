import React,{useState, useEffect} from 'react'
import ApartmentService from '../../../services/ApartmentService'
import { InfoWrapper, Column1, TextWrapper, Subtitle, Heading, TopLine, InfoContainer, Column2, ImgWrap, InfoRow, BtnWrap, Img} from '../../elements/AdvertisementElement.js'
import apartmentImage from '../../../assets/img/apartment-one.jpg'
import { Button, ButtonDelete } from '../../elements/ButtonElement'
import '../../../assets/css/apartments.css'
import '../../../assets/css/pagination.css'

import Pagination from '../../utils/Pagination';
import PaginationHelper from '../../utils/PaginationHelper';


export const Apartments = ({lightBg,id,imgStart,topLine,lightText,headLine,description,buttonLabel,darkText,img,alt, primary,dark,dark2}) => {

  const[apartments, setApartments] = useState([]);
  const [paginatedApartments, setPaginatedApartments] = useState([]);
  const [size, setSize] = useState(2);
  const [currentPage, setCurrentPage] = useState(0);
	const [apartmentsPerPage] = useState(2);

  const fetchPaginatedApartments = async () =>{
    ApartmentService.getApartmentsPaginatedWithParams(currentPage, size)
    .then(response => {
      setPaginatedApartments(response.data.content);
    })
  };

  useEffect(() => {

    fetchPaginatedApartments();

    ApartmentService.getApartmentsPaginated()
    .then(response => {
      setApartments(response.data.content);
    })

  }, []);

  const paginate = (pageNumber) => {

		setCurrentPage(pageNumber);

		ApartmentService.getApartmentsPaginatedWithParams(currentPage,size)
		.then(response => {
			setPaginatedApartments(response.data.content);
		})

	}

  const nextPage = async () => {
		let nextPage = currentPage + 1;
		setCurrentPage(nextPage)

		PaginationHelper.displayPaginated(nextPage, size, ApartmentService.getApartmentsPaginatedWithParams, setPaginatedApartments)


	}	


	const previousPage = async () => {
		let previousPage = currentPage - 1;
		if(currentPage < 0){
			setCurrentPage(0)
		}
		setCurrentPage(previousPage)
	
		PaginationHelper.displayPaginated(previousPage, size, ApartmentService.getApartmentsPaginatedWithParams, setPaginatedApartments)


	}

  return (
    <section className="content">
   
    {paginatedApartments.map((apartment) => (
        <InfoContainer lightBg={lightBg} id={id}>
        <InfoWrapper>
            <InfoRow imgStart={imgStart}>
                <Column1>
                    <TextWrapper>
                        <TopLine>{apartment.numberOfBeds} Beds, {apartment.numberOfRooms} Rooms</TopLine>
                        <TopLine>{apartment.petFriendly ? <p>Pet Friendly</p> : <p style={{color:'none;'}}>Pets are not allowed</p>}</TopLine>

                        <Heading><b>Adress: </b> {apartment.address}, {apartment.city}</Heading>
                        <Subtitle darkText={darkText}><b>Contact at: </b>{apartment.owner.email}</Subtitle>
                        <Subtitle darkText={darkText}><b>Owner: </b>{apartment.owner.user.name + " " + apartment.owner.user.lastname}</Subtitle>

                        <BtnWrap>
                            <Button
                            smooth={true}
                            duration={500}
                            spy={true}
                            exact="true"
                           
                            >Update</Button>
                             <ButtonDelete
                            
                            smooth={true}
                            duration={500}
                            spy={true}
                            exact="true"
                            offset={-80}
                           
                            >Delete</ButtonDelete>
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
   
   <div class="pagination">
					<ul>
						<li>
							<button onClick={previousPage}>Previous</button>
						</li>
						<li>
							<Pagination
								clientsPerPage={apartmentsPerPage}
								totalClients={apartments.length}
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
  </section>

  
  )
}
