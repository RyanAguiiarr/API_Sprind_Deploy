package one.digitalinnovation.cloud_parking.controller.mapper;

import one.digitalinnovation.cloud_parking.controller.dto.ParkingDTO;
import one.digitalinnovation.cloud_parking.model.Parking;
import org.hibernate.annotations.Comment;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ParkingMapper {

    private static final ModelMapper modelMapper = new ModelMapper();

    public ParkingDTO toParkingDTO(Parking parking) {
        return modelMapper.map(parking, ParkingDTO.class);
    }


    public List<ParkingDTO> toParkingDTOList(List<Parking> parkingList) {
        return parkingList.stream().map(this::toParkingDTO).collect(Collectors.toList());
    }
}
