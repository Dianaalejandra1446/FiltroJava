CREATE TABLE cliente (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(255) NOT NULL,
    apellido VARCHAR(255) NOT NULL,
    email VARCHAR(255),
    direccion VARCHAR(255),
    celular VARCHAR(20),
    documento VARCHAR(20) NOT NULL,
    INDEX idx_cliente_documento (documento)
);

CREATE TABLE producto (
    codigo INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(255) NOT NULL,
    descripcion TEXT,
    precioVenta DECIMAL(10, 2) NOT NULL,
    precioCompra DECIMAL(10, 2) NOT NULL,
    INDEX idx_producto_nombre (nombre)
);

CREATE TABLE factura (
    numeroFactura INT AUTO_INCREMENT PRIMARY KEY,
    fecha DATETIME NOT NULL,
    cliente_id INT,
    FOREIGN KEY (cliente_id) REFERENCES cliente(id),
    INDEX idx_factura_cliente (cliente_id)
);

CREATE TABLE item_factura (
    id INT AUTO_INCREMENT PRIMARY KEY,
    factura_numeroFactura INT,
    producto_codigo INT,
    cantidad INT NOT NULL,
    importe DECIMAL(10, 2) NOT NULL,
    FOREIGN KEY (factura_numeroFactura) REFERENCES factura(numeroFactura),
    FOREIGN KEY (producto_codigo) REFERENCES producto(codigo),
    INDEX idx_item_factura_factura (factura_numeroFactura),
    INDEX idx_item_factura_producto (producto_codigo)
);

CREATE TABLE impuesto_ref (
    id_ref INT PRIMARY KEY,
    periodo_fiscal DATE,
    año DOUBLE,
    porcentaje DOUBLE
);
ALTER TABLE impuesto_ref ADD COLUMN id_impuesto INT;

CREATE TABLE impuestos (
    id_impuesto INT,
    id_cliente INT,
    impuesto_pagado DOUBLE,
    valor_total DOUBLE,
    id_ref INT,
    FOREIGN KEY (id_ref) REFERENCES impuesto_ref(id_ref)
);
ALTER TABLE impuestos ADD COLUMN id_producto INT;
ALTER TABLE impuestos ADD FOREIGN KEY (id_cliente)
REFERENCES cliente(id);

CREATE TABLE descuento (
    id_descuento INT AUTO_INCREMENT PRIMARY KEY,
    tipo_descuento VARCHAR(255),
    condiciones_aplicacion VARCHAR(255),
    porcentaje DOUBLE,
    estado VARCHAR(255),
    id_producto INT,
    id_cliente INT,
    FOREIGN KEY (id_producto) REFERENCES producto(codigo),
    FOREIGN KEY(id_cliente) REFERENCES cliente(id)
);