package Examples;

//////////////////////////////////////////////////////////////////////////
// Copyright (c) 2001-2020 Aspose Pty Ltd. All Rights Reserved.
//
// This file is part of Aspose.Words. The source code in this file
// is only intended as a supplement to the documentation, and is provided
// "as is", without warranty of any kind, either expressed or implied.
//////////////////////////////////////////////////////////////////////////

import com.aspose.words.CompatibilityOptions;
import com.aspose.words.Document;
import com.aspose.words.MsWordVersion;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.text.MessageFormat;
import java.util.SortedSet;

@Test
public class ExCompatibilityOptions extends ApiExampleBase {
    //ExStart
    //ExFor:Compatibility
    //ExFor:CompatibilityOptions
    //ExFor:CompatibilityOptions.OptimizeFor(MsWordVersion)
    //ExFor:Document.CompatibilityOptions
    //ExSummary:Shows how to optimize document for different word versions.
    @Test(enabled = false) //ExSkip
    public void optimizeFor() throws Exception {
        // Create a blank document and get its CompatibilityOptions object
        Document doc = new Document();
        CompatibilityOptions options = doc.getCompatibilityOptions();

        // By default, the CompatibilityOptions will contain the set of values printed below
        System.out.println("\nDefault optimization settings:");
        printCompatibilityOptions(options);

        // These attributes can be accessed in the output document via File > Options > Advanced > Compatibility for...
        doc.save(getArtifactsDir() + "CompatibilityOptions.OptimizeFor.DefaultSettings.docx");

        // We can use the OptimizeFor method to set these values automatically
        // for maximum compatibility with some Microsoft Word versions
        doc.getCompatibilityOptions().optimizeFor(MsWordVersion.WORD_2010);
        System.out.println("\nOptimized for Word 2010:");
        printCompatibilityOptions(options);

        doc.getCompatibilityOptions().optimizeFor(MsWordVersion.WORD_2000);
        System.out.println("\nOptimized for Word 2000:");
        printCompatibilityOptions(options);
    }

    /// <summary>
    /// Prints all options of a CompatibilityOptions object and indicates whether they are enabled or disabled
    /// </summary>
    private static void printCompatibilityOptions(CompatibilityOptions options) throws IntrospectionException {
        for (int i = 1; i >= 0; i--) {
            System.out.println((i != 0) ? "\tEnabled options:" : "\tDisabled options:");
            SortedSet<String> optionNames = null;

            BeanInfo infoAboutFoo = Introspector.getBeanInfo(CompatibilityOptions.class);
            PropertyDescriptor[] fooDescriptors = infoAboutFoo.getPropertyDescriptors();

            for (PropertyDescriptor descriptor : fooDescriptors) {
                if (descriptor.getPropertyType().getTypeName() == "boolean" && i == (int) descriptor.getValue(String.valueOf(options))) {
                    optionNames.add(descriptor.getName());
                }
            }

            for (String s : optionNames) {
                System.out.println(MessageFormat.format("\t\t{0}", s));
            }
        }
    }
    //ExEnd

    @Test
    public void tables() throws Exception {
        Document doc = new Document();

        CompatibilityOptions compatibilityOptions = doc.getCompatibilityOptions();
        compatibilityOptions.optimizeFor(MsWordVersion.WORD_2002);

        Assert.assertEquals(false, compatibilityOptions.getAdjustLineHeightInTable());
        Assert.assertEquals(false, compatibilityOptions.getAlignTablesRowByRow());
        Assert.assertEquals(true, compatibilityOptions.getAllowSpaceOfSameStyleInTable());
        Assert.assertEquals(true, compatibilityOptions.getDoNotAutofitConstrainedTables());
        Assert.assertEquals(true, compatibilityOptions.getDoNotBreakConstrainedForcedTable());
        Assert.assertEquals(false, compatibilityOptions.getDoNotBreakWrappedTables());
        Assert.assertEquals(false, compatibilityOptions.getDoNotSnapToGridInCell());
        Assert.assertEquals(false, compatibilityOptions.getDoNotUseHTMLParagraphAutoSpacing());
        Assert.assertEquals(true, compatibilityOptions.getDoNotVertAlignCellWithSp());
        Assert.assertEquals(false, compatibilityOptions.getForgetLastTabAlignment());
        Assert.assertEquals(true, compatibilityOptions.getGrowAutofit());
        Assert.assertEquals(false, compatibilityOptions.getLayoutRawTableWidth());
        Assert.assertEquals(false, compatibilityOptions.getLayoutTableRowsApart());
        Assert.assertEquals(false, compatibilityOptions.getNoColumnBalance());
        Assert.assertEquals(false, compatibilityOptions.getOverrideTableStyleFontSizeAndJustification());
        Assert.assertEquals(false, compatibilityOptions.getUseSingleBorderforContiguousCells());
        Assert.assertEquals(true, compatibilityOptions.getUseWord2002TableStyleRules());
        Assert.assertEquals(false, compatibilityOptions.getUseWord2010TableStyleRules());

        // These options will become available in File > Options > Advanced > Compatibility Options in the output document
        doc.save(getArtifactsDir() + "CompatibilityOptions.Tables.docx");
    }

    @Test
    public void breaks() throws Exception {
        Document doc = new Document();

        CompatibilityOptions compatibilityOptions = doc.getCompatibilityOptions();
        compatibilityOptions.optimizeFor(MsWordVersion.WORD_2000);

        Assert.assertEquals(false, compatibilityOptions.getApplyBreakingRules());
        Assert.assertEquals(true, compatibilityOptions.getDoNotUseEastAsianBreakRules());
        Assert.assertEquals(false, compatibilityOptions.getShowBreaksInFrames());
        Assert.assertEquals(true, compatibilityOptions.getSplitPgBreakAndParaMark());
        Assert.assertEquals(true, compatibilityOptions.getUseAltKinsokuLineBreakRules());
        Assert.assertEquals(false, compatibilityOptions.getUseWord97LineBreakRules());

        // These options will become available in File > Options > Advanced > Compatibility Options in the output document
        doc.save(getArtifactsDir() + "CompatibilityOptions.Breaks.docx");
    }

    @Test
    public void spacing() throws Exception {
        Document doc = new Document();

        CompatibilityOptions compatibilityOptions = doc.getCompatibilityOptions();
        compatibilityOptions.optimizeFor(MsWordVersion.WORD_2000);

        Assert.assertEquals(false, compatibilityOptions.getAutoSpaceLikeWord95());
        Assert.assertEquals(true, compatibilityOptions.getDisplayHangulFixedWidth());
        Assert.assertEquals(false, compatibilityOptions.getNoExtraLineSpacing());
        Assert.assertEquals(false, compatibilityOptions.getNoLeading());
        Assert.assertEquals(false, compatibilityOptions.getNoSpaceRaiseLower());
        Assert.assertEquals(false, compatibilityOptions.getSpaceForUL());
        Assert.assertEquals(false, compatibilityOptions.getSpacingInWholePoints());
        Assert.assertEquals(false, compatibilityOptions.getSuppressBottomSpacing());
        Assert.assertEquals(false, compatibilityOptions.getSuppressSpBfAfterPgBrk());
        Assert.assertEquals(false, compatibilityOptions.getSuppressSpacingAtTopOfPage());
        Assert.assertEquals(false, compatibilityOptions.getSuppressTopSpacing());
        Assert.assertEquals(false, compatibilityOptions.getUlTrailSpace());

        // These options will become available in File > Options > Advanced > Compatibility Options in the output document
        doc.save(getArtifactsDir() + "CompatibilityOptions.Spacing.docx");
    }

    @Test
    public void wordPerfect() throws Exception {
        Document doc = new Document();

        CompatibilityOptions compatibilityOptions = doc.getCompatibilityOptions();
        compatibilityOptions.optimizeFor(MsWordVersion.WORD_2000);

        Assert.assertEquals(false, compatibilityOptions.getSuppressTopSpacingWP());
        Assert.assertEquals(false, compatibilityOptions.getTruncateFontHeightsLikeWP6());
        Assert.assertEquals(false, compatibilityOptions.getWPJustification());
        Assert.assertEquals(false, compatibilityOptions.getWPSpaceWidth());
        Assert.assertEquals(false, compatibilityOptions.getWrapTrailSpaces());

        // These options will become available in File > Options > Advanced > Compatibility Options in the output document
        doc.save(getArtifactsDir() + "CompatibilityOptions.WordPerfect.docx");
    }

    @Test
    public void alignment() throws Exception {
        Document doc = new Document();

        CompatibilityOptions compatibilityOptions = doc.getCompatibilityOptions();
        compatibilityOptions.optimizeFor(MsWordVersion.WORD_2000);

        Assert.assertEquals(true, compatibilityOptions.getCachedColBalance());
        Assert.assertEquals(true, compatibilityOptions.getDoNotVertAlignInTxbx());
        Assert.assertEquals(true, compatibilityOptions.getDoNotWrapTextWithPunct());
        Assert.assertEquals(false, compatibilityOptions.getNoTabHangInd());

        // These options will become available in File > Options > Advanced > Compatibility Options in the output document
        doc.save(getArtifactsDir() + "CompatibilityOptions.Alignment.docx");
    }

    @Test
    public void legacy() throws Exception {
        Document doc = new Document();

        CompatibilityOptions compatibilityOptions = doc.getCompatibilityOptions();
        compatibilityOptions.optimizeFor(MsWordVersion.WORD_2000);

        Assert.assertEquals(false, compatibilityOptions.getFootnoteLayoutLikeWW8());
        Assert.assertEquals(false, compatibilityOptions.getLineWrapLikeWord6());
        Assert.assertEquals(false, compatibilityOptions.getMWSmallCaps());
        Assert.assertEquals(false, compatibilityOptions.getShapeLayoutLikeWW8());
        Assert.assertEquals(false, compatibilityOptions.getUICompat97To2003());

        // These options will become available in File > Options > Advanced > Compatibility Options in the output document
        doc.save(getArtifactsDir() + "CompatibilityOptions.Legacy.docx");
    }

    @Test
    public void list() throws Exception {
        Document doc = new Document();

        CompatibilityOptions compatibilityOptions = doc.getCompatibilityOptions();
        compatibilityOptions.optimizeFor(MsWordVersion.WORD_2000);

        Assert.assertEquals(true, compatibilityOptions.getUnderlineTabInNumList());
        Assert.assertEquals(true, compatibilityOptions.getUseNormalStyleForList());

        // These options will become available in File > Options > Advanced > Compatibility Options in the output document
        doc.save(getArtifactsDir() + "CompatibilityOptions.List.docx");
    }

    @Test
    public void misc() throws Exception {
        Document doc = new Document();

        CompatibilityOptions compatibilityOptions = doc.getCompatibilityOptions();
        compatibilityOptions.optimizeFor(MsWordVersion.WORD_2000);

        Assert.assertEquals(false, compatibilityOptions.getBalanceSingleByteDoubleByteWidth());
        Assert.assertEquals(false, compatibilityOptions.getConvMailMergeEsc());
        Assert.assertEquals(false, compatibilityOptions.getDoNotExpandShiftReturn());
        Assert.assertEquals(false, compatibilityOptions.getDoNotLeaveBackslashAlone());
        Assert.assertEquals(false, compatibilityOptions.getDoNotSuppressParagraphBorders());
        Assert.assertEquals(true, compatibilityOptions.getDoNotUseIndentAsNumberingTabStop());
        Assert.assertEquals(false, compatibilityOptions.getPrintBodyTextBeforeHeader());
        Assert.assertEquals(false, compatibilityOptions.getPrintColBlack());
        Assert.assertEquals(true, compatibilityOptions.getSelectFldWithFirstOrLastChar());
        Assert.assertEquals(false, compatibilityOptions.getSubFontBySize());
        Assert.assertEquals(false, compatibilityOptions.getSwapBordersFacingPgs());
        Assert.assertEquals(false, compatibilityOptions.getTransparentMetafiles());
        Assert.assertEquals(true, compatibilityOptions.getUseAnsiKerningPairs());
        Assert.assertEquals(false, compatibilityOptions.getUseFELayout());
        Assert.assertEquals(false, compatibilityOptions.getUsePrinterMetrics());

        // These options will become available in File > Options > Advanced > Compatibility Options in the output document
        doc.save(getArtifactsDir() + "CompatibilityOptions.Misc.docx");
    }
}