package com.github.intuit.innersource.reposcanner.evaluators.builtin;

import com.github.intuit.innersource.reposcanner.evaluators.EvaluationContext;
import com.github.intuit.innersource.reposcanner.evaluators.FileCheckEvaluator;
import com.github.intuit.innersource.reposcanner.evaluators.FileInfo;
import com.github.intuit.innersource.reposcanner.specification.InnerSourceReadinessSpecification.FileCheck;
import com.google.auto.service.AutoService;

/**
 * Evaluator for "PATH_MATCHES_EXPECTED" FileCheck.
 */
@AutoService(FileCheckEvaluator.class)
public final class PathMatchesExpectedFileCheckEvaluator implements FileCheckEvaluator {

    @Override
    public String getFileCheckRequirementName() {
        return "PATH_MATCHES_EXPECTED";
    }

    @Override
    public boolean evaluate(
        final FileInfo fileToEvaluate,
        final FileCheck fileCheckToEvaluate,
        final EvaluationContext context
    ) {
        return context
            .getOptionToEvaluate()
            .fileToFind()
            .expectedFilePath()
            .equalsIgnoreCase(fileToEvaluate.path().toFilePathString());
    }
}
