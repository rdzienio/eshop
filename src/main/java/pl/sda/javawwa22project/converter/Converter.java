package pl.sda.javawwa22project.converter;

public interface Converter<E,D> {

    D fromEntity(E entity);
    E fromDTO(D dto);
}
