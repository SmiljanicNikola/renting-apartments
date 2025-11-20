import React, { useEffect, useState } from "react";
import { useParams } from "react-router-dom";
import AdvertisementService from "../../../services/AdvertisementService";
import { Button } from "../../elements/ButtonElement";
import '../../../assets/css/advertisementDetails.css'

export const AdvertisementDetails = () => {
  const { id } = useParams();
  const [advertisement, setAdvertisement] = useState(null);

  useEffect(() => {
    AdvertisementService.getAdvertisementById(id)
      .then((response) => {
        setAdvertisement(response.data);
      })
      .catch((error) => {
        console.error("Error fetching advertisement:", error);
      });
  }, [id]);

  const handleBooking = () => {
    alert("Booking functionality coming soon!");
  };

  if (!advertisement) return <div className="loading">Loading...</div>;

  const apartment = advertisement.apartment;

  return (
    <div className="advertisement-detail-container">
      <div className="advertisement-card">
        <div className="advertisement-image">
          <img
            src={advertisement.imageUrl || "/placeholder.jpg"}
            alt={apartment.apartmentName}
          />
        </div>
        <div className="advertisement-info">
          <h1>{apartment.apartmentName}</h1>
          <p className="price">${advertisement.price} / night</p>
          <div className="details-grid">
            <p><strong>City:</strong> {apartment.city}</p>
            <p><strong>Address:</strong> {apartment.address}</p>
            <p><strong>Rooms:</strong> {apartment.numberOfRooms}</p>
            <p><strong>Beds:</strong> {apartment.numberOfBeds}</p>
            <p><strong>Pet Friendly:</strong> {apartment.petFriendly ? "Yes" : "No"}</p>
          </div>
          <Button onClick={handleBooking}>Book Now</Button>
        </div>
      </div>
    </div>
  );
};

export default AdvertisementDetails;