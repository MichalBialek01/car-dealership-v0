package pl.bialek.infrastructure.database.repository.mapper;

import pl.bialek.domain.Invoice;
import pl.bialek.infrastructure.database.entity.InvoiceEntity;

public interface InvoiceMapper {
    InvoiceEntity mapToEntity(Invoice invoice);
}
