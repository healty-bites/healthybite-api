-- Administradores
INSERT INTO public.administrador (id, nombre, email, contrasena)
VALUES
    (1, 'Ana Perez', 'ana.perez@example.com', 'password123'),
    (2, 'Luis Gomez', 'luis.gomez@example.com', 'password456'),
    (3, 'Maria Rodriguez', 'maria.rodriguez@example.com', 'password789'),
    (4, 'Juan Fernandez', 'juan.fernandez@example.com', 'password987'),
    (5, 'Sofia Morales', 'sofia.morales@example.com', 'password654'),
    (6, 'Carlos Lopez', 'carlos.lopez@example.com', 'password321')
    ON CONFLICT DO NOTHING;

-- Grupos de Interés
INSERT INTO public.grupo_interes (nombre, es_privado)
VALUES
    ('Grupo Fitness', false),
    ('Grupo Veganismo', true),
    ('Grupo Salud Mental', false),
    ('Grupo Running', false),
    ('Grupo Culturismo', true),
    ('Grupo Yoga', false)
    ON CONFLICT DO NOTHING;

-- Hábitos
INSERT INTO public.habito (hidratacion, alimentacion, ejercicio, calidad_sueno)
VALUES
    (2.5, 3.0, 1.5, 4.0),
    (3.0, 2.5, 2.0, 3.5),
    (2.0, 2.0, 1.0, 4.5),
    (2.5, 3.5, 1.5, 3.0),
    (3.0, 3.0, 2.0, 4.0),
    (2.0, 2.5, 1.0, 3.5)
    ON CONFLICT DO NOTHING;

-- Progreso
INSERT INTO public.progreso (peso_objetivo)
VALUES
    (55.0),
    (80.0),
    (50.0),
    (70.0),
    (48.0),
    (85.0)
    ON CONFLICT DO NOTHING;

-- Suscripciones
INSERT INTO public.suscripcion (tipo, precio, fecha_inicio, fecha_fin)
VALUES
    ('BASICO', 29.99, '2023-01-01', '2023-12-31'),
    ('PREMIUM', 59.99, '2023-01-01', '2023-12-31'),
    ('PREMIUM', 99.99, '2023-01-01', '2023-12-31'),
    ('BASICO', 29.99, '2023-02-01', '2024-01-31'),
    ('PREMIUM', 59.99, '2023-02-01', '2024-01-31'),
    ('BASICO', 99.99, '2023-02-01', '2024-01-31')
    ON CONFLICT DO NOTHING;


-- Planes de Alimentación
INSERT INTO public.plan_alimentacion (nombre, objetivo, duracion_dias, administrador_id)
VALUES
    ('Plan Saludable', 'PERDER_PESO', 30, 6),
    ('Plan Musculación', 'GANAR_MASA_MUSCULAR', 60, 2),
    ('Plan Balanceado', 'MANTENER_PESO', 45, 5),
    ('Plan Vegano', 'MANTENER_PESO', 30, 2),
    ('Plan Detox', 'PERDER_PESO', 15, 3),
    ('Plan Alto en Proteínas', 'GANAR_MASA_MUSCULAR', 40, 4)
    ON CONFLICT DO NOTHING;

-- Comidas Diarias
INSERT INTO public.comida_diaria (administrador_id, nombre, calorias, categoria_comida, plan_alimentacion_id, descripcion)
VALUES
    (1, 'Ensalada de Pollo', 350, 'ALMUERZO', '6', 'Ensalada con pollo a la parrilla'),
    (1, 'Batido de Frutas', 200, 'DESAYUNO', '5','Batido con frutas y yogur'),
    (2, 'Batido Proteico', 200, 'DESAYUNO', '4','Batido de proteína con frutas'),
    (2, 'Pasta Integral', 400, 'ALMUERZO', '3', 'Pasta integral con verduras'),
    (3, 'Sopa de Verduras', 180, 'CENA', '2', 'Sopa ligera de vegetales'),
    (3, 'Pollo al Horno', 300, 'CENA', '1', 'Pollo al horno con especias')
    ON CONFLICT DO NOTHING;

-- Clientes
INSERT INTO public.cliente (id, nombre, email, contrasena, sexo, edad, altura, peso, grupo_interes_id, habitos_id, plan_actual_id, progreso_id, suscripcion_id)
VALUES
    (1, 'Pedro Martinez', 'pedro.martinez@example.com', 'password123', 'M', 30, 1.75, 70.0, 1, 1, 1, 1, 1),
    (2, 'Laura Sanchez', 'laura.sanchez@example.com', 'password456', 'F', 28, 1.65, 60.0, 2, 2, 2, 2, 2),
    (3, 'Miguel Torres', 'miguel.torres@example.com', 'password789', 'M', 35, 1.80, 80.0, 3, 3, 3, 3, 3),
    (4, 'Ana Lopez', 'ana.lopez@example.com', 'password987', 'F', 32, 1.70, 65.0, 4, 4, 4, 4, 4),
    (5, 'Jose Ramirez', 'jose.ramirez@example.com', 'password654', 'M', 40, 1.85, 90.0, 5, 5, 5, 5, 5),
    (6, 'Elena Fernandez', 'elena.fernandez@example.com', 'password321', 'F', 25, 1.60, 55.0, 6, 6, 6, 6, 6)
    ON CONFLICT DO NOTHING;

-- Publicaciones
INSERT INTO public.publicacion (contenido, grupo_interes_id, autor_id)
VALUES
    ('Cómo empezar con el ejercicio', 1, 1),
    ('Beneficios del veganismo', 2, 2),
    ('Cómo mantener la salud mental', 3, 3),
    ('Rutinas de running para principiantes', 4, 4),
    ('Suplementos para culturismo', 5, 5),
    ('Posturas de yoga para dormir mejor', 6, 6)
    ON CONFLICT DO NOTHING;

-- Comentarios
INSERT INTO public.comentario (autor_id, publicacion_id, mensaje, comentario_padre_id)
VALUES
    (1, 1, '¡Gran publicación!', NULL),
    (2, 1, 'Gracias por compartir', 1),
    (3, 2, 'Muy útil esta información', NULL),
    (4, 2, 'Estoy de acuerdo', 3),
    (5, 3, 'Interesante enfoque', NULL),
    (6, 4, 'Voy a probar esto', NULL)
    ON CONFLICT DO NOTHING;

-- Contenidos
INSERT INTO public.contenido (titulo, descripcion, tipo_contenido, categoria, administrador_id)
VALUES
    ('Guía de Ejercicios', 'Una guía completa de ejercicios para principiantes', 'ARTICULO', 'EJERCICIO', 1),
    ('Recetas Saludables', 'Recetas para mantener una dieta balanceada', 'VIDEO', 'NUTRICION', 2),
    ('Plan de Entrenamiento', 'Plan semanal de entrenamiento', 'GUIA', 'EJERCICIO', 1),
    ('Beneficios del Yoga', 'Explorando los beneficios del yoga', 'ARTICULO', 'SALUD_MENTAL', 3),
    ('Alimentos para Ganar Masa', 'Alimentos recomendados para ganar masa muscular', 'VIDEO', 'NUTRICION', 2),
    ('Ejercicios en Casa', 'Ejercicios que puedes hacer en casa sin equipo', 'GUIA', 'EJERCICIO', 5)
    ON CONFLICT DO NOTHING;

-- Registro de Progreso
INSERT INTO public.registro_progreso (fecha, peso_actual, observaciones, progreso_id)
VALUES
    ('2023-01-01 08:15:00', 75.0, 'Buen progreso', 1),
    ('2023-02-01 09:45:00', 70.0, 'Excelente avance', 2),
    ('2023-03-01 14:30:00', 85.0, 'Manteniendo el ritmo', 3),
    ('2023-04-01 11:00:00', 65.0, 'Resultados positivos', 4),
    ('2023-05-01 16:20:00', 90.0, 'Objetivo cercano', 5),
    ('2023-06-01 07:50:00', 55.0, 'Progreso satisfactorio', 6)
    ON CONFLICT DO NOTHING;

-- Pagos
INSERT INTO public.pago (suscripcion_id, estado_pago)
VALUES
    (1, 'PAGADO'),
    (2, 'PROCESO'),
    (3, 'PAGADO'),
    (4, 'PAGADO'),
    (5, 'FALLIDO'),
    (6, 'PAGADO')
    ON CONFLICT DO NOTHING;

-- Intereses de los Clientes
INSERT INTO public.interes_cliente (cliente_id, grupo_interes_id)
VALUES
    (1, 1),
    (2, 2),
    (3, 3),
    (4, 4),
    (5, 5),
    (6, 6)
    ON CONFLICT DO NOTHING;