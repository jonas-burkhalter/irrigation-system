export default {
    //////////////
    /// UNUSED ///
    //////////////
    unused: 'unused ???',

    //////////////
    /// COMMON ///
    //////////////
    common: {
        actions: '',
        application: {
            title: 'Irrigation System'
        },
        cancel: 'Abbrechen',
        date: 'Datum',
        delete: 'Löschen',
        language: 'Sprache',
        login: 'Login',
        logout: 'Logout',
        name: 'Name',
        next: 'Weiter',
        number: 'Nummer',
        repeat: 'Wiederholen',
        save: 'Speichern',
        state: 'Status',
        total: 'Betrag',
        time: 'Zeit',
        title: 'Titel'
    },

    //////////////////
    /// COMPONENTS ///
    //////////////////
    components: {
        deleteConfirm: {
            cancel: '@:common.cancel',
            confirm: '@:common.delete',
            text: 'Möchten sie diesen Eintrag wirklich löschen?',
            title: 'Löschen bestätigen'
        }
    },

    ///////////////
    /// VUETIFY ///
    ///////////////
    noDataText: 'Kein Eintrag vorhanden',
    dataTable: {
        ariaLabel: {
            activateAscending: '@:unused',
            sortNone: '@:unused'
        },
        sortBy: 'Sortiert nach'
    },

    /////////////
    /// AREAS ///
    /////////////
    areas: {
        authenticate: {
            messages: {
                login: {
                    200: '',
                    401: 'Login fehlgeschlagen'
                },
                register: {
                    201: 'Benutzer erfolgreich registiert.',
                    409: 'Ein Benutzer mit diesem Namen existiert bereits.',
                    415: 'unsupported content type'
                }
            },
            name: 'Name',
            login: 'Login',
            logout: 'Logout',
            password: 'Passwort',
            register: 'Registrieren'
        },
        todos: {
            create: {
                title: 'Todo erstellen'
            },
            edit: {
                title: 'Todo bearbeiten'
            },
            list: {
                category: '@:areas.todos.todo.category',
                completed: '@:areas.todos.todo.completed',
                dueDate: '@:areas.todos.todo.dueDate',
                important: '@:areas.todos.todo.important',
                title: '@:areas.todos.todo.title'
            },
            messages: {
                delete: {
                    204: 'Eintrag erfolgreich entfernt',
                    401: 'user not authenticated',
                    403: 'user not authorized',
                    404: 'Der Eintrag konnte nicht gefunden werden'
                },
                get_all: {
                    200: '',
                    401: 'user not authenticated',
                    406: 'unsupported accept type'
                },
                get: {
                    200: '',
                    401: 'user not authenticated',
                    403: 'user not authorized',
                    404: 'todo not found',
                    406: 'unsupported accept type'
                },
                post: {
                    201: 'Eintrag erfolgreich hinzugefügt.',
                    400: 'Die angegebenen Daten sind nicht valid.',
                    401: 'user not authenticated',
                    406: 'unsupported accept type',
                    415: 'unsupported content type'
                },
                put: {
                    200: 'Eintrag erfolgreich bearbeitet',
                    400: 'Die angegebenen Daten sind nicht valid.',
                    401: 'user not authenticated',
                    403: 'user not authorized',
                    404: 'Der Eintrag konnte nicht gefunden werden',
                    406: 'unsupported accept type',
                    415: 'unsupported content type'
                }
            },
            navigation: 'Todos',
            search: 'Todo suchen',
            todo: {
                category: 'Kategorie',
                completed: 'Abgeschlossen',
                dueDate: 'Fälligkeitsdatum',
                important: 'Wichtig',
                title: '@:common.title'
            }
        }
    }
};
