package cheboksarov.blps_lab1.service;

import cheboksarov.blps_lab1.model.Coefficient;

public interface CoefficientService {
    Coefficient findById(Long coeff_id);
    Coefficient saveCoefficient(Coefficient coefficient);

    Coefficient createDefaultCoefficient();

    Coefficient updateCoefficient(Coefficient coefficient);

    void deleteCoefficient(Long coeffId);
}
