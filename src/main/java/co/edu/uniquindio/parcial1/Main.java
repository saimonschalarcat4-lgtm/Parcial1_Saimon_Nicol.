import javax.swing.JOptionPane;

/**
 * Clase ejecutable del sistema de DevPlus.
 * Implementa un menú iterativo (do-while + switch) usando JOptionPane
 * para probar todas las funcionalidades principales del sistema.
 */
public class Main {

    public static void main(String[] args) {

        // 1. Crear la instancia principal de la empresa
        Empresa empresa = new Empresa("DevPlus", "900123456-7",
                "Calle 10 # 20-30, Armenia", "6067400000", "www.devplus.com");

        // 2. Precargar datos de ejemplo (quemados) para facilitar las pruebas
        cargarDatosDePrueba(empresa);

        String opcion;
        boolean continuar = true;

        // 3. Menú iterativo con do-while
        do {
            opcion = JOptionPane.showInputDialog(null,
                    "===== SISTEMA DEVPLUS =====\n"
                            + "1. Registrar cliente\n"
                            + "2. Registrar desarrollador\n"
                            + "3. Registrar servicio adicional\n"
                            + "4. Registrar proyecto\n"
                            + "5. Asociar desarrollador a un proyecto\n"
                            + "6. Asociar servicio a un proyecto\n"
                            + "7. Calcular valor total de un proyecto\n"
                            + "8. Cambiar estado de un proyecto\n"
                            + "9. Consultar ingresos por fecha\n"
                            + "10. Verificar si el teléfono de un cliente es número perfecto\n"
                            + "11. Listar proyectos registrados\n"
                            + "0. Salir\n\n"
                            + "Seleccione una opción:");

            // Si el usuario cierra el diálogo, opcion queda null -> salimos
            if (opcion == null) {
                break;
            }

            int op;
            try {
                op = Integer.parseInt(opcion.trim());
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Por favor ingrese un número válido.");
                continue;
            }

            switch (op) {
                case 1:
                    registrarCliente(empresa);
                    break;
                case 2:
                    registrarDesarrollador(empresa);
                    break;
                case 3:
                    registrarServicio(empresa);
                    break;
                case 4:
                    registrarProyecto(empresa);
                    break;
                case 5:
                    asociarDesarrollador(empresa);
                    break;
                case 6:
                    asociarServicio(empresa);
                    break;
                case 7:
                    calcularValorProyecto(empresa);
                    break;
                case 8:
                    cambiarEstadoProyecto(empresa);
                    break;
                case 9:
                    consultarIngresosPorFecha(empresa);
                    break;
                case 10:
                    verificarTelefonoPerfecto(empresa);
                    break;
                case 11:
                    listarProyectos(empresa);
                    break;
                case 0:
                    continuar = false;
                    JOptionPane.showMessageDialog(null, "¡Gracias por usar el sistema DevPlus!");
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opción no válida.");
                    break;
            }

        } while (continuar);
    }

    // ---------- Carga de datos de prueba ----------
    private static void cargarDatosDePrueba(Empresa empresa) {
        // Clientes (uno de ellos con teléfono cuyos últimos dígitos forman
        // un número perfecto: 28 -> "3000000028")
        Cliente c1 = new Cliente("Laura Gómez", "1094567890", "3000000028",
                "laura.gomez@correo.com", "Colombia");
        Cliente c2 = new Cliente("Carlos Pérez", "1098765432", "3109988776",
                "carlos.perez@correo.com", "Colombia");
        empresa.registrarCliente(c1);
        empresa.registrarCliente(c2);

        // Desarrolladores
        Desarrollador d1 = new Desarrollador("DEV01", "Backend", "Senior",
                3, 150000, "Disponible");
        Desarrollador d2 = new Desarrollador("DEV02", "Frontend", "Junior",
                2, 80000, "Disponible");
        empresa.registrarDesarrollador(d1);
        empresa.registrarDesarrollador(d2);

        // Servicios adicionales
        ServicioAdicional s1 = new ServicioAdicional("SERV01", "Soporte técnico",
                "Soporte 24/7 durante un mes", 200000, true);
        ServicioAdicional s2 = new ServicioAdicional("SERV02", "Capacitación",
                "Capacitación de uso del sistema", 150000, true);
        empresa.registrarServicio(s1);
        empresa.registrarServicio(s2);

        // Un proyecto de ejemplo ya con un desarrollador y un servicio asociados
        Proyecto p1 = new Proyecto("PROY01", "2026-09-24", "2026-09-25",
                "2026-10-25", "Pendiente", "Transferencia", 20);
        p1.agregarDesarrollador(d1);
        p1.agregarServicio(s1);
        p1.calcularValorTotal(0);
        empresa.registrarProyecto(p1);
        c1.agregarProyecto(p1);
    }

    // ---------- Opción 1 ----------
    private static void registrarCliente(Empresa empresa) {
        String nombre = JOptionPane.showInputDialog("Nombre completo del cliente:");
        String documento = JOptionPane.showInputDialog("Documento / NIT:");
        String telefono = JOptionPane.showInputDialog("Teléfono:");
        String correo = JOptionPane.showInputDialog("Correo:");
        String pais = JOptionPane.showInputDialog("País:");

        Cliente cliente = new Cliente(nombre, documento, telefono, correo, pais);
        empresa.registrarCliente(cliente);

        JOptionPane.showMessageDialog(null, "Cliente registrado con éxito:\n" + cliente);
    }

    // ---------- Opción 2 ----------
    private static void registrarDesarrollador(Empresa empresa) {
        String codigo = JOptionPane.showInputDialog("Código del desarrollador:");
        String equipo = JOptionPane.showInputDialog("Equipo de trabajo:");
        String nivel = JOptionPane.showInputDialog("Nivel (Junior/Semi Senior/Senior):");
        int cantidadMax = Integer.parseInt(
                JOptionPane.showInputDialog("Cantidad máxima de proyectos:"));
        double tarifa = Double.parseDouble(
                JOptionPane.showInputDialog("Tarifa por día:"));

        Desarrollador dev = new Desarrollador(codigo, equipo, nivel,
                cantidadMax, tarifa, "Disponible");
        empresa.registrarDesarrollador(dev);

        JOptionPane.showMessageDialog(null, "Desarrollador registrado con éxito:\n" + dev);
    }

    // ---------- Opción 3 ----------
    private static void registrarServicio(Empresa empresa) {
        String codigo = JOptionPane.showInputDialog("Código del servicio:");
        String nombre = JOptionPane.showInputDialog("Nombre del servicio:");
        String descripcion = JOptionPane.showInputDialog("Descripción:");
        double precio = Double.parseDouble(
                JOptionPane.showInputDialog("Precio:"));

        ServicioAdicional servicio = new ServicioAdicional(codigo, nombre, descripcion,
                precio, true);
        empresa.registrarServicio(servicio);

        JOptionPane.showMessageDialog(null, "Servicio registrado con éxito:\n" + servicio);
    }

    // ---------- Opción 4 ----------
    private static void registrarProyecto(Empresa empresa) {
        String codigo = JOptionPane.showInputDialog("Código del proyecto:");
        String fechaSolicitud = JOptionPane.showInputDialog("Fecha de solicitud (AAAA-MM-DD):");
        String fechaInicio = JOptionPane.showInputDialog("Fecha de inicio (AAAA-MM-DD):");
        String fechaEntrega = JOptionPane.showInputDialog("Fecha de entrega (AAAA-MM-DD):");
        String metodoPago = JOptionPane.showInputDialog("Método de pago (Efectivo/Transferencia/Tarjeta):");
        int dias = Integer.parseInt(
                JOptionPane.showInputDialog("Días de desarrollo:"));

        Proyecto proyecto = new Proyecto(codigo, fechaSolicitud, fechaInicio,
                fechaEntrega, "Pendiente", metodoPago, dias);
        empresa.registrarProyecto(proyecto);

        JOptionPane.showMessageDialog(null, "Proyecto registrado con éxito:\n" + proyecto);
    }

    // ---------- Opción 5 ----------
    private static void asociarDesarrollador(Empresa empresa) {
        Proyecto proyecto = seleccionarProyecto(empresa);
        if (proyecto == null) return;

        Desarrollador dev = seleccionarDesarrollador(empresa);
        if (dev == null) return;

        boolean agregado = proyecto.agregarDesarrollador(dev);
        if (agregado) {
            JOptionPane.showMessageDialog(null,
                    "Desarrollador asociado correctamente al proyecto " + proyecto.getCodigo());
        } else {
            JOptionPane.showMessageDialog(null,
                    "No se pudo asociar: el desarrollador no está Disponible o el proyecto está lleno.");
        }
    }

    // ---------- Opción 6 ----------
    private static void asociarServicio(Empresa empresa) {
        Proyecto proyecto = seleccionarProyecto(empresa);
        if (proyecto == null) return;

        ServicioAdicional servicio = seleccionarServicio(empresa);
        if (servicio == null) return;

        boolean agregado = proyecto.agregarServicio(servicio);
        if (agregado) {
            JOptionPane.showMessageDialog(null,
                    "Servicio asociado correctamente al proyecto " + proyecto.getCodigo());
        } else {
            JOptionPane.showMessageDialog(null,
                    "No se pudo asociar: el proyecto alcanzó el máximo de servicios.");
        }
    }

    // ---------- Opción 7 ----------
    private static void calcularValorProyecto(Empresa empresa) {
        Proyecto proyecto = seleccionarProyecto(empresa);
        if (proyecto == null) return;

        double descuento = Double.parseDouble(
                JOptionPane.showInputDialog("Descuento a aplicar (0 si no aplica):"));

        double total = proyecto.calcularValorTotal(descuento);
        JOptionPane.showMessageDialog(null,
                "Valor total del proyecto " + proyecto.getCodigo() + ": $" + total);
    }

    // ---------- Opción 8 ----------
    private static void cambiarEstadoProyecto(Empresa empresa) {
        Proyecto proyecto = seleccionarProyecto(empresa);
        if (proyecto == null) return;

        String nuevoEstado = JOptionPane.showInputDialog(
                "Nuevo estado (Pendiente/Confirmado/Finalizado):");
        proyecto.cambiarEstado(nuevoEstado);

        JOptionPane.showMessageDialog(null,
                "Estado del proyecto " + proyecto.getCodigo() + " actualizado a: " + nuevoEstado);
    }

    // ---------- Opción 9 ----------
    private static void consultarIngresosPorFecha(Empresa empresa) {
        String fecha = JOptionPane.showInputDialog("Ingrese la fecha a consultar (AAAA-MM-DD):");
        double ingresos = empresa.calcularIngresosPorFecha(fecha);

        JOptionPane.showMessageDialog(null,
                "Ingresos generados por proyectos solicitados el " + fecha + ": $" + ingresos);
    }

    // ---------- Opción 10 ----------
    private static void verificarTelefonoPerfecto(Empresa empresa) {
        String telefono = JOptionPane.showInputDialog("Ingrese el teléfono del cliente a consultar:");
        Cliente cliente = empresa.buscarClientePorTelefono(telefono);

        if (cliente == null) {
            JOptionPane.showMessageDialog(null, "No se encontró un cliente con ese teléfono.");
            return;
        }

        boolean esPerfecto = cliente.esTelefonoPerfecto();
        String mensaje = cliente.getNombreCompleto() + " (" + telefono + ") "
                + (esPerfecto ? "SÍ" : "NO") + " tiene un número perfecto.";
        JOptionPane.showMessageDialog(null, mensaje);
    }

    // ---------- Opción 11 ----------
    private static void listarProyectos(Empresa empresa) {
        int cantidad = empresa.getCantidadProyectos();
        if (cantidad == 0) {
            JOptionPane.showMessageDialog(null, "No hay proyectos registrados.");
            return;
        }

        Proyecto[] proyectos = empresa.getProyectos();
        String lista = "";
        for (int i = 0; i < cantidad; i++) {
            lista = lista + proyectos[i].toString() + "\n";
        }
        JOptionPane.showMessageDialog(null, "Proyectos registrados:\n" + lista);
    }

    // ---------- Métodos auxiliares de selección por código ----------
    private static Proyecto seleccionarProyecto(Empresa empresa) {
        String codigo = JOptionPane.showInputDialog("Ingrese el código del proyecto:");
        Proyecto[] proyectos = empresa.getProyectos();
        for (int i = 0; i < empresa.getCantidadProyectos(); i++) {
            if (proyectos[i].getCodigo().equalsIgnoreCase(codigo)) {
                return proyectos[i];
            }
        }
        JOptionPane.showMessageDialog(null, "Proyecto no encontrado.");
        return null;
    }

    private static Desarrollador seleccionarDesarrollador(Empresa empresa) {
        String codigo = JOptionPane.showInputDialog("Ingrese el código del desarrollador:");
        Desarrollador[] desarrolladores = empresa.getDesarrolladores();
        for (int i = 0; i < empresa.getCantidadDesarrolladores(); i++) {
            if (desarrolladores[i].getCodigo().equalsIgnoreCase(codigo)) {
                return desarrolladores[i];
            }
        }
        JOptionPane.showMessageDialog(null, "Desarrollador no encontrado.");
        return null;
    }

    private static ServicioAdicional seleccionarServicio(Empresa empresa) {
        String codigo = JOptionPane.showInputDialog("Ingrese el código del servicio:");
        ServicioAdicional[] servicios = empresa.getServicios();
        for (int i = 0; i < empresa.getCantidadServicios(); i++) {
            if (servicios[i].getCodigo().equalsIgnoreCase(codigo)) {
                return servicios[i];
            }
        }
        JOptionPane.showMessageDialog(null, "Servicio no encontrado.");
        return null;
    }
}