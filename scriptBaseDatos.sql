DROP DATABASE IF EXISTS farmacia;
CREATE DATABASE IF NOT EXISTS farmacia;
USE farmacia;

CREATE TABLE roles(
    IdRol int(11) NOT NULL AUTO_INCREMENT,
    NombreRol VARCHAR(100) NOT NULL,
    PRIMARY KEY (IdRol)
);

CREATE TABLE clientes(
    IdCLiente int(11) NOT NULL AUTO_INCREMENT,
    NombreCliente VARCHAR(300) NOT NULL,
    Subvencionado BIT NOT NULL,
    PRIMARY KEY (IdCliente)
);

CREATE TABLE empleados(
    IdEmpleado  int(11) NOT NULL AUTO_INCREMENT,
    NombreEmpleado VARCHAR(300) NOT NULL,
    Usuario VARCHAR(100) NOT NULL,
    Contrasenia VARCHAR(100) NOT NULL,
    Telefono int (9) NOT NULL,
    IdRol int(11) NOT NULL,

    PRIMARY KEY (IdEmpleado),
    CONSTRAINT FK_Rol FOREIGN KEY (IdRol) REFERENCES roles (IdRol)
);

CREATE TABLE ventas(
    IdVenta  int(11) NOT NULL AUTO_INCREMENT,
    FechaVenta DATETIME not NULL,
    IdEmpleado int(11) not null,
    IdCliente int(11) not null,

    PRIMARY KEY(IdVenta),
    CONSTRAINT FK_Empleado FOREIGN KEY (IdEmpleado) REFERENCES empleados (IdEmpleado),
    CONSTRAINT FK_Cliente FOREIGN KEY (IdCliente) REFERENCES clientes (IdCliente)
);

CREATE TABLE detalleDeVenta(
    IdDetalleVenta int(11) not null AUTO_INCREMENT,
    IdVenta int(11) NOT NULL,
    Importe int(11) not null,
    PRIMARY KEY(IdDetalleVenta),
    CONSTRAINT FK_Venta FOREIGN KEY (IdVenta) REFERENCES ventas (IdVenta)
);

CREATE TABLE productos(
    IdProducto int(11) not null,
    Caducidad int(11) not null,
    Nombre varchar(100) not null,
    Descripcion varchar(300) not null,
    Importe int(11) not null,
    PRIMARY KEY(IdProducto)
);

CREATE TABLE detalleVentaProd(
    IdProducto int(11) not null,
    IdDetalleVenta int(11) not null,
    Unidades int(11) not null,

    CONSTRAINT FK_Producto FOREIGN KEY (IdProducto) REFERENCES productos (IdProducto),
    CONSTRAINT FK_DetalleVenta FOREIGN KEY (IdDetalleVenta) REFERENCES detalleDeVenta (IdDetalleVenta)
);

CREATE TABLE prooveedores(
    IdProoveedor int(11) not null AUTO_INCREMENT,
    Nombre VARCHAR(100) not null,
    PRIMARY KEY(IdProoveedor)
);

CREATE TABLE compras(
    IdCompra  int(11) NOT NULL AUTO_INCREMENT,
    FechaCompra DATETIME not NULL,
    IdEmpleado int(11) not null,
    IdProoveedor int(11) not null,

    PRIMARY KEY(IdCompra),
    CONSTRAINT FK_Empleado2 FOREIGN KEY (IdEmpleado) REFERENCES empleados (IdEmpleado),
    CONSTRAINT FK_Prooveedor FOREIGN KEY (IdProoveedor) REFERENCES prooveedores (IdProoveedor)
);

CREATE TABLE detalleDeCompra(
    IdDetalleCompra int(11) not null AUTO_INCREMENT,
    IdCompra int(11) NOT NULL,
    Importe int(11) not null,
    PRIMARY KEY(IdDetalleCompra),
    CONSTRAINT FK_Compra FOREIGN KEY (IdCompra) REFERENCES compras (IdCompra)
);

CREATE TABLE detalleCompraProd(
    IdProducto int(11) not null,
    IdDetalleCompra int(11) not null,
    Unidades int(11) not null,

    CONSTRAINT FK_Producto2 FOREIGN KEY (IdProducto) REFERENCES productos (IdProducto),
    CONSTRAINT FK_DetalleCompra FOREIGN KEY (IdDetalleCompra) REFERENCES detalleDeCompra (IdDetalleCompra)
);