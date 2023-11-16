package br.com.libbradocs.generator.uf;

public enum UF {
    AC {
        @Override
        public String getNome() {
            return "Acre";
        }

        @Override
        public Integer getDigitoRegiao() {
            return 2;
        }
    },
    AL {
        @Override
        public String getNome() {
            return "Alagoas";
        }

        @Override
        public Integer getDigitoRegiao() {
            return 4;
        }
    },
    AP {
        @Override
        public String getNome() {
            return "Amapá";
        }

        @Override
        public Integer getDigitoRegiao() {
            return 2;
        }
    },
    AM {
        @Override
        public String getNome() {
            return "Amazonas";
        }

        @Override
        public Integer getDigitoRegiao() {
            return 2;
        }
    },
    BA {
        @Override
        public String getNome() {
            return "Bahia";
        }

        @Override
        public Integer getDigitoRegiao() {
            return 5;
        }
    },
    CE {
        @Override
        public String getNome() {
            return "Ceará";
        }

        @Override
        public Integer getDigitoRegiao() {
            return 3;
        }
    },
    DF {
        @Override
        public String getNome() {
            return "Distrito Federal";
        }

        @Override
        public Integer getDigitoRegiao() {
            return 1;
        }
    },
    ES {
        @Override
        public String getNome() {
            return "Espírito Santo";
        }

        @Override
        public Integer getDigitoRegiao() {
            return 7;
        }
    },
    GO {
        @Override
        public String getNome() {
            return "Goiás";
        }

        @Override
        public Integer getDigitoRegiao() {
            return 1;
        }
    },
    MA {
        @Override
        public String getNome() {
            return "Maranhão";
        }

        @Override
        public Integer getDigitoRegiao() {
            return 3;
        }
    },
    MT {
        @Override
        public String getNome() {
            return "Mato Grosso";
        }

        @Override
        public Integer getDigitoRegiao() {
            return 1;
        }
    },
    MS {
        @Override
        public String getNome() {
            return "Mato Grosso do Sul";
        }

        @Override
        public Integer getDigitoRegiao() {
            return 1;
        }
    },
    MG {
        @Override
        public String getNome() {
            return "Minas Gerais";
        }

        @Override
        public Integer getDigitoRegiao() {
            return 6;
        }
    },
    PA {
        @Override
        public String getNome() {
            return "Pará";
        }

        @Override
        public Integer getDigitoRegiao() {
            return 2;
        }
    },
    PB {
        @Override
        public String getNome() {
            return "Paraíba";
        }

        @Override
        public Integer getDigitoRegiao() {
            return 4;
        }
    },
    PR {
        @Override
        public String getNome() {
            return "Paraná";
        }

        @Override
        public Integer getDigitoRegiao() {
            return 9;
        }
    },
    PE {
        @Override
        public String getNome() {
            return "Pernambuco";
        }

        @Override
        public Integer getDigitoRegiao() {
            return 4;
        }
    },
    PI {
        @Override
        public String getNome() {
            return "Piauí";
        }

        @Override
        public Integer getDigitoRegiao() {
            return 3;
        }
    },
    RJ {
        @Override
        public String getNome() {
            return "Rio de Janeiro";
        }

        @Override
        public Integer getDigitoRegiao() {
            return 7;
        }
    },
    RN {
        @Override
        public String getNome() {
            return "Rio Grande do Norte";
        }

        @Override
        public Integer getDigitoRegiao() {
            return 4;
        }
    },
    RS {
        @Override
        public String getNome() {
            return "Rio Grande do Sul";
        }

        @Override
        public Integer getDigitoRegiao() {
            return 0;
        }
    },
    RO {
        @Override
        public String getNome() {
            return "Rondônia";
        }

        @Override
        public Integer getDigitoRegiao() {
            return 2;
        }
    },
    RR {
        @Override
        public String getNome() {
            return "Roraima";
        }

        @Override
        public Integer getDigitoRegiao() {
            return 2;
        }
    },
    SC {
        @Override
        public String getNome() {
            return "Santa Catarina";
        }

        @Override
        public Integer getDigitoRegiao() {
            return 9;
        }
    },
    SP {
        @Override
        public String getNome() {
            return "São Paulo";
        }

        @Override
        public Integer getDigitoRegiao() {
            return 8;
        }
    },
    SE {
        @Override
        public String getNome() {
            return "Sergipe";
        }

        @Override
        public Integer getDigitoRegiao() {
            return 5;
        }
    },
    TO {
        @Override
        public String getNome() {
            return "Tocantins";
        }

        @Override
        public Integer getDigitoRegiao() {
            return 1;
        }
    };

    public abstract String getNome();

    public abstract Integer getDigitoRegiao();

}
